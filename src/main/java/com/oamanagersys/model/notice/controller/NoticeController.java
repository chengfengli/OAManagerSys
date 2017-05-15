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
	
	/**
	 * 待审通知页面
	 * @return
	 */
	@RequestMapping("/careful_list")
	public String carefulMsg(){	
		return "pages/notice/careful_list";
	}
	
	/**
	 * 新增通知页面
	 * @return
	 */
	@RequestMapping("/add_notice")
	public String addNotice(){	
		return "pages/notice/add_notice";
	}
	
	/**
	 * 通知管理页面
	 * @return
	 */
	@RequestMapping("/notice_manager")
	public String noticeManager(){	
		return "pages/notice/notice_manager";
	}
}
