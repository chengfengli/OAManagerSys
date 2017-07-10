package com.oamanagersys.model.email.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.model.email.entity.SearchEmail;
import com.oamanagersys.model.email.service.EmailService;
import com.oamanagersys.model.file.entity.FileEntity;
import com.oamanagersys.model.file.service.FileService;
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
	@Autowired
	private FileService fielService;
	/**
	 * 写邮件
	 * @return
	 */
	@RequestMapping("/writerEmail")
	public ModelAndView writerEmail(SearchEmail searchEmail,String type,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/email/email_add");
		List<Emp> list = userService.getAllEmp(new Emp());
		mav.addObject("back", false);
		if(searchEmail.getId()!=0){
			List<Email> email_list = emailService.selectInbox(searchEmail);
			if(list.size() >0){
				if("forward".equals(type)){
					email_list.get(0).setTitle("转发："+email_list.get(0).getTitle());
				}
				mav.addObject("email", email_list.get(0));
				mav.addObject("back", true);
			}
		}
		
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
	 * 收件：详情页面
	 * @return
	 */
	@RequestMapping("/details")
	public ModelAndView detailsEmail(SearchEmail searchEmail,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/email/email_details");
		List<Email> list = emailService.selectInbox(searchEmail);
		if(list.size() > 0){
			Email email = list.get(0);
			if(StringUtils.isBlank(email.getReadTime())){
				emailService.updateReaded(Integer.toString(searchEmail.getId()));
			}
			mav.addObject("email", list.get(0));
		}
		return mav;
	}
	/**
	 * 发件：详情页面
	 * @return
	 */
	@RequestMapping("/send_details")
	public ModelAndView send_detailsEmail(SearchEmail searchEmail,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/email/email_details");
		List<Email> list = emailService.selectOutbox(searchEmail);
		if(list.size() > 0){
			String fileId = list.get(0).getFileId();
			FileEntity file = new FileEntity();
			file.setFileId(fileId);
			List<FileEntity> files = fielService.select(file);
			list.get(0).setList(files);
			mav.addObject("email", list.get(0));
		}
		return mav;
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
		List<Emp> emps = userService.getEmpById(email.getAcceptNo());
		String name ="";
		for(int i =0;i<emps.size();i++){
			name += emps.get(i).getName()+";";
			
		}
		email.setAcceptName(name);
		int count  = emailService.send(email);
		if(count > 0){
			map.put("isSuccess", true);
			map.put("strMessage", "发送成功");
			map.put("acceptNo", email.getAcceptNo());
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
		List<Emp> emps = userService.getEmpById(email.getAcceptNo());
		String name ="";
		for(int i =0;i<emps.size();i++){
			name += emps.get(i).getName()+";";
			
		}
		email.setAcceptName(name);
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
	public Message readed(String ids,HttpServletRequest request){
		int count = emailService.updateReaded(ids);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "标记成功";
		}else{
			message.isSuccess = false;
		}
		return message;
	}
	
	/**
	 * 删除邮件
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(String ids){
		int count = emailService.deleteEmail(ids);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "删除成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "删除失败";
		}
		return message;
	}
	
	/**
	 * 发件箱
	 * @return
	 */
	@RequestMapping("/outboxList")
	@ResponseBody
	public Map<String,List<Email>> selectOutbox(SearchEmail searchEmail,HttpServletRequest request){
		Map<String,List<Email>> map = new HashMap<String,List<Email>>();
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		searchEmail.setSendNo(currentEmp.getId());
		List<Email> list = emailService.selectOutbox(searchEmail);
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 草稿箱
	 * @return
	 */
	@RequestMapping("/drartList")
	@ResponseBody
	public Map<String,List<Email>> selectDrart(SearchEmail searchEmail,HttpServletRequest request){
		Map<String,List<Email>> map = new HashMap<String,List<Email>>();
		Emp currentEmp = (Emp)request.getSession().getAttribute("user");
		searchEmail.setSendNo(currentEmp.getId());
		List<Email> list = emailService.selectDrart(searchEmail);
		map.put("Rows", list);
		return map;
	}
	
	
	
}