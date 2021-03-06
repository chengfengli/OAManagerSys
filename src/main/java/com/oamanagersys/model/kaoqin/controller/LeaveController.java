package com.oamanagersys.model.kaoqin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午5:50:58
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
	/**
	 * 请假登记列表页面
	 * @return
	 */
	@RequestMapping("/leavelist")
	public ModelAndView LeaveListPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/leavelist");
		return mav;
	}
	
	/**
	 * 请假页面
	 * @return
	 */
	@RequestMapping("/leave")
	public ModelAndView LeavePage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/leave");
		return mav;
	}
}
