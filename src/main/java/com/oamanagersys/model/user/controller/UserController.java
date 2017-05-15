package com.oamanagersys.model.user.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.oamanagersys.util.annotation.AnnotationUtil;

/**
 * 创建人： 李明
 * 时    间：2017年3月23日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/user")
public class UserController {
	/**
	 * 添加员工页面
	 */
	@RequestMapping("/adduser")
	public ModelAndView addUser(){
		ModelAndView mav = new ModelAndView("pages/usermanager/adduser");
		return mav;
	}
	/**
	 * 员工信息管理
	 */
	@RequestMapping("/userlist")
	public String staffInfor(){
		return "pages/usermanager/userlist";
	}
	
	/**
	 * 编辑信息页面
	 */
	@RequestMapping("/editinfomation")
	public ModelAndView infoMationPage(){
		ModelAndView mav = new ModelAndView("pages/manageset/editinfomation");
		return mav;
	}
	
	/**
	 * 账号与安全
	 */
	@RequestMapping("/accountsecurity")
	public ModelAndView accountSecurityPage(){
		ModelAndView mav = new ModelAndView("pages/manageset/accountsecurity");
		return mav;
	}
	
	/**
	 * 权限
	 */
	@RequestMapping("/setpermission")
	public ModelAndView setPermission(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/usermanager/setpermission");
		//获取顶级菜单
		List<String> list = AnnotationUtil.getClasses("com.oamanagersys.menu");
		List<Map<String, String>> result = AnnotationUtil.getClassName(list);
		mav.addObject("lists", result);
		//获取子菜单
		Map<String,Object> childMap = AnnotationUtil.ReadJsonFile("./WEB-INF/classes/childmenu.properties",request);
		String str = JSON.toJSONString(childMap);
		mav.addObject("childMenu", str);
		return mav;
	}
}
