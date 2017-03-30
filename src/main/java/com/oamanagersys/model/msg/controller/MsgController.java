package com.oamanagersys.model.msg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oamanagersys.util.annotation.ChildMenu;

/**
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/msg")
public class MsgController {
	
	/**
	 * 写邮件
	 * @return
	 */
	@ChildMenu(id="personalissue",title="内部短信",text="写短息",url="msg/writerMsg")
	@RequestMapping("/writerMsg")
	public String writerMsg(){
		return "msg/msg_add";
	}
}
