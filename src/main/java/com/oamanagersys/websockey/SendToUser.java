package com.oamanagersys.websockey;

import java.util.List;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
/**
 * 给指定用户发消息
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月19日 下午3:26:39
 */
public class SendToUser extends Thread {
	//消息
	private List<TextMessage> mesList;
	private WebSocketSession socketSession;
	public SendToUser(List<TextMessage> mesList,WebSocketSession socketSession) {
		this.mesList = mesList;
		this.socketSession = socketSession;
	}

	public void run() {
		if (socketSession != null && socketSession.isOpen()) {
			for(int i=0;i<mesList.size();i++){
				try {
					Thread.sleep(10);
					socketSession.sendMessage(mesList.get(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
}
