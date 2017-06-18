package com.oamanagersys.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.oamanagersys.model.department.entity.Position;
import com.oamanagersys.model.department.service.PostService;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.annotation.AnnotationUtil;
/**
 * 程序入口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/index")
public class MainController {
	@Autowired
	private PostService postService;
	@RequestMapping("/toindex")
	public ModelAndView toIndex(ModelAndView mav,HttpServletRequest request){
		Emp user = (Emp)request.getSession().getAttribute("user");
		if(user==null){
			mav.setViewName("pages/login/login");
			return mav;
		}
		//用户角色
		List<Position> positions = postService.getPsotById(user.getPositionId());
		//是否是管理员
		boolean isAdmin = false;
		for(int i=0;i<positions.size();i++){
			if("ADMIN".equals(positions.get(i).getPositionCode())){
				isAdmin = true;
			}
		}
		
		if(isAdmin){
			//获取顶级菜单
			List<String> list = AnnotationUtil.getClasses("com.oamanagersys.menu");
			List<Map<String, String>> result = AnnotationUtil.getClassName(list);
			mav.addObject("lists", result);
			//获取子菜单
			Map<String,Object> childMap = AnnotationUtil.ReadJsonFile("./WEB-INF/classes/childmenu.properties",request);
			String str = JSON.toJSONString(childMap);
			System.out.println(str);
			mav.addObject("childMenu", str);
		}else{
			String parentMenu = positions.get(0).getParentMenu();
			String childMenu = positions.get(0).getChildMenu();
			mav.addObject("currentPosition", positions.get(0).getPositionCode());
			List<Object> list = (List<Object>)JSON.parse(parentMenu);
			mav.addObject("lists", list);
			mav.addObject("childMenu", childMenu);
		}
		mav.addObject("positions", positions);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/tologin")
	public ModelAndView toLogin(ModelAndView mav){
		mav.setViewName("pages/login/login");
		return mav;
	}
	
	//切换角色
	@RequestMapping("/switchrole")
	public ModelAndView switchRole(ModelAndView mav,HttpServletRequest request,String positionCode){
		Emp user = (Emp)request.getSession().getAttribute("user");
		if(user==null){
			mav.setViewName("pages/login/login");
			return mav;
		}
		//用户角色
		List<Position> positions = postService.getPsotById(user.getPositionId());
		for(int i=0;i<positions.size();i++){
			if(positions.get(i).getPositionCode().equals(positionCode)){
				String parentMenu = positions.get(i).getParentMenu();
				String childMenu = positions.get(i).getChildMenu();
				List<Object> list = (List<Object>)JSON.parse(parentMenu);
				mav.addObject("lists", list);
				mav.addObject("childMenu", childMenu);
			}
		}
		mav.addObject("positions", positions);
		mav.addObject("currentPosition", positionCode);
		mav.setViewName("index");
		return mav;
	}
}
