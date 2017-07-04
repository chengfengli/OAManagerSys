package com.oamanagersys.model.email.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.model.email.service.EmailService;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.model.user.service.UserService;
import com.oamanagersys.util.response.Message;


@Controller
@RequestMapping("/email")
public class EmailController {
	Message message = new Message();
	@Autowired
	private UserService userService;
	@Autowired
	private EmailService emailService;
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
	
	/**
	 * 发送邮件
	 * @return
	 */
	@RequestMapping("/doSend")
	@ResponseBody
	public Message doSend(Email email,HttpServletRequest request){
		Emp currentEmp = (Emp)request.getAttribute("user");
		email.setSendNo(currentEmp.getId());
		email.setCreateUser(currentEmp.getId());
		int count  = emailService.send(email);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "发送成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "发送失败";
		}
		return message;
	}
}