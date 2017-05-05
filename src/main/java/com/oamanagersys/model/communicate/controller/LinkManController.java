package com.oamanagersys.model.communicate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:20:15
 */
@Controller
@RequestMapping("/linkman")
public class LinkManController {
	/**
	 * 联系人列表页面
	 * @return
	 */
	@RequestMapping("/linkmanlist")
	public String linkManListPage(){
		return "pages/communicate/linkmanlist";
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/addlinkman")
	public ModelAndView addLinkManPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/communicate/addlinkman");
		return mav;
	}
}
