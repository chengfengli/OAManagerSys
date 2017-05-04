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
@RequestMapping("/chuchai")
public class ChuChaiController {
	/**
	 * 请假登记列表页面
	 * @return
	 */
	@RequestMapping("/chuchailist")
	public ModelAndView chuchaiListPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/chuchailist");
		return mav;
	}
	
	/**
	 * 请假页面
	 * @return
	 */
	@RequestMapping("/chuchai")
	public ModelAndView chuchaiPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/chuchai");
		return mav;
	}
}
