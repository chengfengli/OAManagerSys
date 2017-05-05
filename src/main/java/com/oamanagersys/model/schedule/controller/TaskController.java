package com.oamanagersys.model.schedule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 下午12:15:19
 */
@Controller
@RequestMapping("/task")
public class TaskController {
	/**
	 * 我的任务列表页面
	 * @return
	 */
	@RequestMapping("/tasklist")
	public String taskListPage(){
		return "pages/schedule/tasklist";
	}
	
	/**
	 * 添加任务页面
	 * @return
	 */
	@RequestMapping("/addtask")
	public ModelAndView addTaskPage(){
		ModelAndView mav = new ModelAndView("pages/schedule/addtask");
		return mav;
	}
}
