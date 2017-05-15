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
	
	/**
	 * 添加/编辑新闻页面
	 * @return
	 */
	@RequestMapping("/add_news")
	public ModelAndView addNews(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/news/add_news");
		return mav;
	}
	
	/**
	 * 新闻管理页面
	 * @return
	 */
	@RequestMapping("/news_manager")
	public String newsManager(){
		return "pages/news/news_manager";
	}
}
