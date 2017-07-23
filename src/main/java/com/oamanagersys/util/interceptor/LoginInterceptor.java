package com.oamanagersys.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录拦截器
 * @author 李明
 * @time 2017年7月2日 下午10:29:03
 * @phone 17310545652
 */
public class LoginInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e)
			throws Exception {
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView arg3)
			throws Exception {
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		//获取Session
		Object user = request.getSession().getAttribute("user");
        if(user != null){
        	return true;
        }else{
        	//不符合条件的，跳转到登录界面
            request.getRequestDispatcher("/index/toindex").forward(request, response);
        	return false;
        }
	}

}
