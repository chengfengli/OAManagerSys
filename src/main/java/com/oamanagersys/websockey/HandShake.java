package com.oamanagersys.websockey;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * Socket建立连接（握手）和断开
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月19日 下午2:37:57
 */
public class HandShake implements HandshakeInterceptor {

	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
		
	}
	/**
	 * 登录成功之后，连接之前
	 */
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> map) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			// 标记用户
			String userId = session.getAttribute("userId").toString();
			String userName = session.getAttribute("userName").toString();
			if(userId!=null){
				map.put("userId", userId);
				map.put("userName", userName);
			}else{
				return false;
			}
		}
		return true;
	}

}
