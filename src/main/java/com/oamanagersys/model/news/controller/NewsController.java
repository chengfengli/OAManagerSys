package com.oamanagersys.model.news.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("news")
public class NewsController {
	/**
	 * 所有新闻页面
	 * @return
	 */
	@RequestMapping("/all_list")
	public ModelAndView allList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/news/all_list");
		return mav;
	}
	
	/**
	 * 未读新闻页面
	 * @return
	 */
	@RequestMapping("/unread_list")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/news/unread_list");
		return mav;
	}
}
