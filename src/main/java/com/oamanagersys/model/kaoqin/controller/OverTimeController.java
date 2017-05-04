package com.oamanagersys.model.kaoqin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 创建人： 李明
 * 时    间：2017年5月4日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/overtime")
public class OverTimeController {
	/**
	 * 加班列表页面
	 * @return
	 */
	@RequestMapping("/overtimelist")
	public ModelAndView overTimeListPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/overtimelist");
		return mav;
	}
	
	/**
	 * 加班申请页面
	 * @return
	 */
	@RequestMapping("/overtime")
	public ModelAndView chuchaiPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/overtime");
		return mav;
	}
}
