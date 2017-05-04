package com.oamanagersys.model.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/email")
public class EmailController {
	/**
	 * 写邮件
	 * @return
	 */
	@RequestMapping("/writerEmail")
	public String writerEmail(){
		return "pages/email/email_add";
	}
	/**
	 * 收件箱
	 * @return
	 */
	@RequestMapping("/InboxEmail")
	public String InboxEmail(){
		return "pages/email/email_inbox";
	}
	/**
	 * 草稿箱
	 * @return
	 */
	@RequestMapping("/draftboxEmail")
	public String draftboxEmail(){
		return "pages/email/email_draft";
	}
	/**
	 * 已发送
	 * @return
	 */
	@RequestMapping("/sendboxEmail")
	public String sendboxEmail(){
		return "pages/email/email_sended";
	}
	/**
	 * 详情页面
	 * @return
	 */
	@RequestMapping("/details")
	public String detailsEmail(){
		return "pages/email/email_details";
	}
	
	
}