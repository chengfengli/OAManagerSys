package com.oamanagersys.model.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oamanagersys.util.annotation.ChildMenu;
/**
 * 创建人： 李明
 * 时    间：2017年3月23日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/staffManager")
public class UserController {
	/**
	 * 添加员工页面
	 */
	@ChildMenu(id="em",title="员工管理",text="添加用户",url="staffManager/addstaff")
	@RequestMapping("/addstaff")
	public void addUser(){
		
	}
	/**
	 * 员工信息管理
	 */
	@ChildMenu(id="em",title="员工管理",text="员工信息管理",url="staffManager/staffInfor")
	@RequestMapping("/staffInfor")
	public void staffInfor(){
		
	}
}
