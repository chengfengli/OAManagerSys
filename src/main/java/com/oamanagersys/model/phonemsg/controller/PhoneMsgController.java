package com.oamanagersys.model.phonemsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 手机短信 controller
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午12:13:30
 */
@Controller
@RequestMapping("phonemsg")
public class PhoneMsgController {
	/**
	 * 编写短息页面
	 * @return
	 */
	@RequestMapping("/writerMsg")
	public ModelAndView writerMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/phone_msg/add");
		return mav;
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/sendedMsg")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/phone_msg/sendedlist");
		return mav;
	}
	
	/**
	 * 草稿页面
	 * @return
	 */
	@RequestMapping("/draftMsg")
	public ModelAndView draftMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/phone_msg/draftlist");
		return mav;
	}
}
