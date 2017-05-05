package com.oamanagersys.model.worklog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午9:55:37
 */
@Controller
@RequestMapping("/worklog")
public class WorkLogController {
	/**
	 * 日志列表页面
	 * @return
	 */
	@RequestMapping("/workloglist")
	public String workLogListPage(){
		return "pages/worklog/workloglist";
	}
	
	/**
	 * 添加工作日志页面
	 * @return
	 */
	@RequestMapping("/addworklog")
	public ModelAndView addWorkLogPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/worklog/addworklog");
		return mav;
	}
}
