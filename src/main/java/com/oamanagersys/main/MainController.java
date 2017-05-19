package com.oamanagersys.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.oamanagersys.util.annotation.AnnotationUtil;
/**
 * 程序入口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/index")
public class MainController {
	@RequestMapping("/toindex")
	public ModelAndView toIndex(ModelAndView mav,HttpServletRequest request){
		request.getSession().setAttribute("userId", "1");
		request.getSession().setAttribute("userName", "张三");
		//获取顶级菜单
		List<String> list = AnnotationUtil.getClasses("com.oamanagersys.menu");
		List<Map<String, String>> result = AnnotationUtil.getClassName(list);
		mav.addObject("lists", result);
		//获取子菜单
		Map<String,Object> childMap = AnnotationUtil.ReadJsonFile("./WEB-INF/classes/childmenu.properties",request);
		String str = JSON.toJSONString(childMap);
		mav.addObject("childMenu", str);
		
		mav.setViewName("pages/login/login");
		return mav;
	}
}
