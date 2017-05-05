package com.oamanagersys.model.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	@RequestMapping("/addstaff")
	public void addUser(){
		
	}
	/**
	 * 员工信息管理
	 */
	@RequestMapping("/staffInfor")
	public void staffInfor(){
		
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
}
