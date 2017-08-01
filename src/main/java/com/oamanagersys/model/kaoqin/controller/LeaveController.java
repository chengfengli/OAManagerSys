package com.oamanagersys.model.kaoqin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.apply.dao.ApplyTypeDao;
import com.oamanagersys.model.apply.entity.ApplyType;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午5:50:58
 */
@Controller
@RequestMapping("/leave")
public class LeaveController {
	@Autowired
	private ApplyTypeDao applyTypeDao;
	/**
	 * 请假登记列表页面
	 * @return
	 */
	@RequestMapping("/leavelist")
	public ModelAndView LeaveListPage(){
		ModelAndView mav = new ModelAndView("pages/kaoqin/leavelist");
		return mav;
	}
	
	/**
	 * 请假页面
	 * @return
	 */
	@RequestMapping("/leave")
	public ModelAndView LeavePage(){
		ModelAndView mav = new ModelAndView("pages/kaoqin/leave");
		List<ApplyType> list = applyTypeDao.select(new ApplyType());
		mav.addObject("types", list);
		return mav;
	}
}
