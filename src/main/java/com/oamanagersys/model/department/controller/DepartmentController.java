package com.oamanagersys.model.department.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月17日 上午11:12:55
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	/**
	 * 部门管理页面
	 * @return
	 */
	@RequestMapping("/departmentlist")
	public String departmentListPage(){
		return "pages/usermanager/departmentlist";
	}
	
	/**
	 * 添加职位页面
	 */
	@RequestMapping("/adddepartment")
	public ModelAndView addPost(){
		ModelAndView mav = new ModelAndView("pages/usermanager/adddepartment");
		return mav;
	}
}
