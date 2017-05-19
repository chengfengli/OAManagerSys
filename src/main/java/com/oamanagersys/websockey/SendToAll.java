package com.oamanagersys.websockey;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * 给所有用户发消息
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月19日 下午3:31:29
 */
public class SendToAll extends Thread {
	private TextMessage message;
	private Iterator<Entry<String, WebSocketSession>> it;
	public SendToAll(TextMessage message,Iterator<Entry<String, WebSocketSession>> it) {
		this.message = message;
		this.it = it;
	}

	public void run() {
		Entry<String, WebSocketSession> entry = it.next();
		synchronized (entry){
			try {
				if (entry.getValue().isOpen()) {
					entry.getValue().sendMessage(message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	

}