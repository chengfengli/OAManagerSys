package com.oamanagersys.model.department.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.oamanagersys.model.department.service.DepService;
import com.oamanagersys.util.annotation.AnnotationUtil;
/**
 * 职位
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月17日 上午11:17:46
 */
@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private DepService depService;
	/**
	 * 职位管理页面
	 */
	@RequestMapping("/postlist")
	public String postlist(){
		return "pages/usermanager/postlist";
	}
	
	/**
	 * 添加职位页面
	 */
	@RequestMapping("/addpost")
	public ModelAndView addPost(){
		ModelAndView mav = new ModelAndView("pages/usermanager/addpost");
		mav.addObject("deps", depService.getDep(null));
		return mav;
	}
	
	/**
	 * 设置页面权限页面
	 */
	@RequestMapping("/setrows")
	public ModelAndView setRows(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/usermanager/setrows");
		//获取顶级菜单
		List<String> list = AnnotationUtil.getClasses("com.oamanagersys.menu");
		List<Map<String, String>> result = AnnotationUtil.getClassName(list);
		mav.addObject("lists", result);
		//获取子菜单
		Map<String,Object> childMap = AnnotationUtil.setJsonFile("./WEB-INF/classes/childmenu.properties",request);
		String str = JSON.toJSONString(childMap);
		System.out.println(str);
		mav.addObject("childMenu", str);
		return mav;
	}
}
