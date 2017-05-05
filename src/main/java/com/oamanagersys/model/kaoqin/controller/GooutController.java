package com.oamanagersys.model.kaoqin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午4:50:26
 */
@Controller
@RequestMapping("/goout")
public class GooutController {
	/**
	 * 外出登记页面
	 * @return
	 */
	@RequestMapping("/goout")
	public ModelAndView GooutPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/goout");
		return mav;
	}
	
	/**
	 * 外出登记列表页面
	 * @return
	 */
	@RequestMapping("/gooutlist")
	public String GooutListPage(){
		return "pages/kaoqin/gooutlist";
	}
}
