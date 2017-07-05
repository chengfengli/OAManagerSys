package com.oamanagersys.model.email.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.model.email.entity.SearchEmail;
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
	public Map<String,Object> doSend(Email email,HttpServletRequest request){
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		Map<String,Object> map = new HashMap<String,Object>();
		email.setSendNo(currentEmp.getId());
		email.setCreateUser(currentEmp.getId());
		int count  = emailService.send(email);
		if(count > 0){
			map.put("isSuccess", true);
			map.put("strMessage", "发送成功");
			map.put("acceptNo", email.getAcceptNo().toString());
			map.put("tips", "你有新的邮件！");
		}else{
			map.put("isSuccess", false);
			map.put("strMessage", "发送失败");
		}
		return map;
	}
	
	/**
	 * 存草稿
	 * @return
	 */
	@RequestMapping("/draft")
	@ResponseBody
	public Message draft(Email email,HttpServletRequest request){
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		email.setSendNo(currentEmp.getId());
		email.setCreateUser(currentEmp.getId());
		int count  = emailService.draft(email);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "保存成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "保存失败";
		}
		return message;
	}
	
	/**
	 * 收件箱
	 * @return
	 */
	@RequestMapping("/inboxList")
	@ResponseBody
	public Map<String,List<Email>> inboxList(SearchEmail searchEmail,HttpServletRequest request){
		Map<String,List<Email>> map = new HashMap<String,List<Email>>();
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		searchEmail.setAcceptNo(Integer.toString(currentEmp.getId()));
		List<Email> list = emailService.selectInbox(searchEmail);
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 标记已读
	 * @return
	 */
	@RequestMapping("/readed")
	@ResponseBody
	public Message readed(SearchEmail searchEmail,HttpServletRequest request){
		Map<String,List<Email>> map = new HashMap<String,List<Email>>();
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		searchEmail.setAcceptNo(Integer.toString(currentEmp.getId()));
		List<Email> list = emailService.selectInbox(searchEmail);
		map.put("Rows", list);
		return message;
	}
	
	
}