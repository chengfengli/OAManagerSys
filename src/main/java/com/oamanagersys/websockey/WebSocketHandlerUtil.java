package com.oamanagersys.websockey;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oamanagersys.websockey.entity.Message;
@Component
public class WebSocketHandlerUtil implements WebSocketHandler {
	//存储在线用户
	public static final Map<String, WebSocketSession> userSocketSessionMap;
	//存储离线消息
	public static final Map<String, List<TextMessage>> mesMap;

	static {
		userSocketSessionMap = new HashMap<String, WebSocketSession>();
		mesMap = new HashMap<String, List<TextMessage>>();
	}
	/**
	 * 建立连接后
	 */
	public void afterConnectionEstablished(WebSocketSession sockeySession) throws Exception {
		//获取当前用户的id
		String userId = sockeySession.getAttributes().get("userId").toString();
		//把当前用户存入在线列表
		userSocketSessionMap.put(userId, sockeySession);
		
		Message message = new Message();
		message.setDate(new Date());
		message.setFrom("-1");
		message.setFromName("系统提示");
		message.setTo("0");
		message.setText("上线");
		//broadcast(new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(message)));
		//判断用户在离线队列中是否有未读消息
		if(mesMap.get(userId)!=null){
			WebSocketSession webSession = userSocketSessionMap.get(userId);
			List<TextMessage> list = mesMap.get(userId);
			mesMap.remove(userId);
			SendToUser sendMsg = new SendToUser(list,webSession);
			sendMsg.start();
		}
	}

	/**
	 * 关闭连接后
	 */
	public void afterConnectionClosed(WebSocketSession sockeySession, CloseStatus arg1) throws Exception {
		//获取当前用户的id
		String userId = sockeySession.getAttributes().get("userId").toString();
		//把当前用户移除在线列表
		userSocketSessionMap.put(userId, sockeySession);
	}
	
	/**
	 * 消息处理，在客户端通过Websocket.send()发送的消息会经过这里，然后进行相应的处理
	 */
	@SuppressWarnings("unused")
	public void handleMessage(WebSocketSession webSession, WebSocketMessage<?> message) throws Exception {
		if(message.getPayloadLength()==0){
			return;
		}
		Message msg=new Gson().fromJson(message.getPayload().toString(),Message.class);
		msg.setDate(new Date());
		webSession = userSocketSessionMap.get(msg.getTo());
		List<TextMessage> msgList = new ArrayList<TextMessage>();
		TextMessage txtMsg = new TextMessage(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create().toJson(msg));
		msgList.add(txtMsg);
		
		if (webSession != null && webSession.isOpen()) {//用户在线
			SendToUser sendMsg = new SendToUser(msgList,webSession);
			sendMsg.start();
		}else{//用户不在线，保到离线消息列表
			List<TextMessage> offLineList = mesMap.get(msg.getTo());
			if(offLineList==null){
				offLineList = new ArrayList<TextMessage>();
			}
			offLineList.add(txtMsg);
			//把接收方用户id及消息加入到离线列表
			mesMap.put(msg.getTo(), msgList);
		}
	}

	/**
	 * 消息传输错误处理
	 */
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		System.out.println("Error");
	}
	
	/**
	 * 给所有在线用户发送消息
	 * @param message
	 * @throws IOException
	 */
	public void broadcast(TextMessage message) {
		Iterator<Entry<String, WebSocketSession>> it = userSocketSessionMap.entrySet().iterator();
		SendToAll sendAll = new SendToAll(message,it);
		sendAll.start();
	}

	public boolean supportsPartialMessages() {
		return false;
	}

}
