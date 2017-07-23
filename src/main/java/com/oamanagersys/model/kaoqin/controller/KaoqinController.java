package com.oamanagersys.model.kaoqin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.kaoqin.entity.Kaoqin;
import com.oamanagersys.model.kaoqin.entity.SearchKaoqin;
import com.oamanagersys.model.kaoqin.service.KaoqinService;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午3:38:27
 */
@Controller
@RequestMapping("/kaoqin")
public class KaoqinController {
	@Autowired
	private KaoqinService kaoqinService;
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
	
	/**
	 * 签到
	 * @return
	 */
	@RequestMapping("/signIn")
	@ResponseBody
	public Message signIn(HttpServletRequest request){
		return kaoqinService.signIn(request);
	}
	
	/**
	 * 签退
	 * @return
	 */
	@RequestMapping("/signOut")
	@ResponseBody
	public Message signOut(HttpServletRequest request){
		return kaoqinService.signOut(request);
	}
	
	/**
	 * 考勤数据
	 * @param search
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,List<Kaoqin>> list(SearchKaoqin search,HttpServletRequest request){
		Map<String,List<Kaoqin>> map = new HashMap<String,List<Kaoqin>>();
		List<Kaoqin> list = kaoqinService.list(search, request);
		map.put("Rows", list);
		return map;
	}
}
