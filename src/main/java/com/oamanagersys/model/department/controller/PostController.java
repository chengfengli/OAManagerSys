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

import com.alibaba.fastjson.JSON;
import com.oamanagersys.model.department.entity.Dep;
import com.oamanagersys.model.department.entity.Position;
import com.oamanagersys.model.department.service.DepService;
import com.oamanagersys.model.department.service.PostService;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.annotation.AnnotationUtil;
import com.oamanagersys.util.response.Message;
/**
 * 职位
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月17日 上午11:17:46
 */
@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private DepService depService;
	
	@Autowired
	private PostService postService;
	/**
	 * 职位管理页面
	 */
	@RequestMapping("/postlist")
	public String postlist(){
		return "pages/usermanager/postlist";
	}
	
	/**
	 * 添加职位页面
	 */
	@RequestMapping("/addpostpage")
	public ModelAndView addPostPage(Dep dep){
		ModelAndView mav = new ModelAndView("pages/usermanager/addpost");
		mav.addObject("deps", depService.getDep(dep));
		return mav;
	}
	/**
	 * 添加角色
	 * @param position
	 * @return
	 */
	@RequestMapping("/addpost")
	@ResponseBody
	public Message addPost(Position position,HttpServletRequest request){
		Message message = new Message();
		Emp emp = (Emp)request.getSession().getAttribute("user");
		int count = 0;
		if(position.getId() == 0){//新增
			position.setCreateUser(emp.getId());
			count = postService.insert(position);
		}else{//修改
			position.setUpdateUser(emp.getId());
			count = postService.update(position);
		}
		if(count > 0){
			message.isSuccess=true;
			message.strMessage="操作成功!";
		}
		return message;
	}
	
	/**
	 * 设置页面权限页面
	 */
	@RequestMapping("/setrows")
	public ModelAndView setRows(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/usermanager/setrows");
		//获取顶级菜单
		List<String> list = AnnotationUtil.getClasses("com.oamanagersys.menu");
		List<Map<String, String>> result = AnnotationUtil.getClassName(list);
		mav.addObject("lists", result);
		//获取子菜单
		Map<String,Object> childMap = AnnotationUtil.ReadJsonFile("./WEB-INF/classes/childmenu.properties",request);
		String str = JSON.toJSONString(childMap);
		System.out.println(str);
		mav.addObject("childMenu", str);
		return mav;
	}
	
	/**
	 * 角色列表
	 * @return
	 */
	@RequestMapping("/getpost")
	@ResponseBody
	public Map<String,Object> getPost(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("Rows", postService.getPsot());
		return map;
	}
}
