package com.oamanagersys.model.email.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.model.user.service.UserService;
import com.oamanagersys.util.response.Message;


@Controller
@RequestMapping("/email")
public class EmailController {
	Message message = new Message();
	@Autowired
	private UserService userService;
	/**
	 * 写邮件
	 * @return
	 */
	@RequestMapping("/writerEmail")
	public ModelAndView writerEmail(){
		List<Emp> list = userService.getAllEmp(new Emp());
		ModelAndView mav = new ModelAndView("pages/email/email_add");
		mav.addObject("emps", list);
		return mav;
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
	
	public Message doSendMiak(){
		
		return message;
	}
}