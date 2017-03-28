package com.oamanagersys.model.email.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oamanagersys.util.annotation.ChildMenu;

@Controller
@RequestMapping("/email")
public class EmailController {
	/**
	 * 写邮件
	 * @return
	 */
	@ChildMenu(id="personalissue",title="电子邮件",text="写信",url="email/writerEmail")
	@RequestMapping("/writerEmail")
	public String writerEmail(){
		return "email/email_add";
	}
	/**
	 * 收件箱
	 * @return
	 */
	@ChildMenu(id="personalissue",title="电子邮件",text="收件箱",url="email/InboxEmail")
	@RequestMapping("/InboxEmail")
	public String InboxEmail(){
		return "email/email_inbox";
	}
	/**
	 * 草稿箱
	 * @return
	 */
	@ChildMenu(id="personalissue",title="电子邮件",text="草稿箱",url="email/draftboxEmail")
	@RequestMapping("/draftboxEmail")
	public String draftboxEmail(){
		return "email/email_draft";
	}
	/**
	 * 已发送
	 * @return
	 */
	@ChildMenu(id="personalissue",title="电子邮件",text="已发送箱",url="email/sendboxEmail")
	@RequestMapping("/sendboxEmail")
	public String sendboxEmail(){
		return "email/email_sendbox";
	}
}