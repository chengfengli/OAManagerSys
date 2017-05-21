package com.oamanagersys.websockey;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/**
 * 1.WebScoket配置处理器
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月19日 下午2:28:16
 */
@Component
@EnableWebSocket
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {
	@Resource
	WebSocketHandlerUtil handlerUtil;
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handlerUtil, "/wshome").addInterceptors(new HandShake());
		registry.addHandler(handlerUtil, "/ws/sockjshome").addInterceptors(new HandShake()).withSockJS();
//		registry.addHandler(handlerUtil, "/wsindex").addInterceptors(new HandShake());
//		registry.addHandler(handlerUtil, "/ws/sockjsindex").addInterceptors(new HandShake()).withSockJS();
	}

}
