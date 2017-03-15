package com.oamanagersys.model.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oamanagersys.util.annotation.ChildMenu;

@Controller
@RequestMapping("/email")
public class EmailController {
	@ChildMenu(id="personalissue",title="电子邮件",text="写信",url="email/writerEmail")
	@RequestMapping("/writerEmail")
	public String writerEmail(){
		return "email/email_add";
	}
}