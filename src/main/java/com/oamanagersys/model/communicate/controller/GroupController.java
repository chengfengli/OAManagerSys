package com.oamanagersys.model.communicate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:25:59
 */
@Controller
@RequestMapping("/group")
public class GroupController {
	/**
	 * 联系人列表页面
	 * @return
	 */
	@RequestMapping("/grouplist")
	public String groupListPage(){
		return "pages/communicate/grouplist";
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/addgroup")
	public ModelAndView addGroupPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/communicate/addgroup");
		return mav;
	}
}
