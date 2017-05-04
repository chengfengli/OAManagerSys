package com.oamanagersys.model.interiormsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 内部短信 controller
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/interiormsg")
public class MsgController {
	
	/**
	 * 编写短息页面
	 * @return
	 */
	@RequestMapping("/writerMsg")
	public ModelAndView writerMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_add");
		return mav;
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/sendedMsg")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_sended");
		return mav;
	}
	
	/**
	 * 已接收短息页面
	 * @return
	 */
	@RequestMapping("/inboxMsg")
	public ModelAndView inboxMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_inbox");
		return mav;
	}
	
	/**
	 * 草稿页面
	 * @return
	 */
	@RequestMapping("/draftMsg")
	public ModelAndView draftMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_draft");
		return mav;
	}
}
