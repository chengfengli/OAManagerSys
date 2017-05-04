package com.oamanagersys.model.kaoqin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午3:38:27
 */
@Controller
@RequestMapping("/kaoqin")
public class KaoqinController {
	/**
	 * 考勤登记页面
	 * @return
	 */
	@RequestMapping("/kaoqin")
	public ModelAndView writerMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/kaoqin/kaoqin");
		return mav;
	}
}
