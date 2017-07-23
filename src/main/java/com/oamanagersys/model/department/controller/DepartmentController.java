package com.oamanagersys.model.department.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.department.entity.Dep;
import com.oamanagersys.model.department.service.DepService;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月17日 上午11:12:55
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepService depService;
	
	
	/**
	 * 部门管理页面
	 * @return
	 */
	@RequestMapping("/departmentlist")
	public String departmentListPage(){
		return "pages/usermanager/departmentlist";
	}
	
	/**
	 * 添加部门页面
	 */
	@RequestMapping("/adddeppage")
	public ModelAndView addDepPage(Dep dep){
		ModelAndView mav = new ModelAndView("pages/usermanager/adddepartment");
		if(dep.getId()!=0){
			List<Dep> list = depService.getDep(dep);
			dep = list.get(0);
			mav.addObject("dep", dep);
		}
		return mav;
	}
	
	/**
	 * 添加部门
	 * @param dep
	 * @return
	 */
	@RequestMapping("/adddep")
	@ResponseBody
	public Message addDep(Dep dep,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		int count = 0;
		if(dep.getId()==0){
			dep.setCreateUser(emp.getId());
			count = depService.addDep(dep);
		}else{
			dep.setUpdateUser(emp.getId());
			count = depService.updateDep(dep);
		}
		Message message = new Message();
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "操作成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "操作失败";
		}
		return message;
	}
	
	/**
	 * 获取部门
	 * @param dep
	 * @return
	 */
	@RequestMapping("/deplist")
	@ResponseBody
	public Map<String,Object> depList(Dep dep,HttpServletRequest request){
		List<Dep> list = depService.getDep(dep);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteDep(String id,HttpServletRequest request){
		int count = depService.deleteDep(id);
		Message message = new Message();
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "操作成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "操作失败";
		}
		return message;
	}
	
	
}
