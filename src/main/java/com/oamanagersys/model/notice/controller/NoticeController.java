package com.oamanagersys.model.notice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("notice")
public class NoticeController {
	/**
	 * 所有通知页面
	 * @return
	 */
	@RequestMapping("/all_list")
	public ModelAndView allList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/notice/all_list");
		return mav;
	}
	
	/**
	 * 未读公告页面
	 * @return
	 */
	@RequestMapping("/unread_list")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/notice/unread_list");
		return mav;
	}
}
