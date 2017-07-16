package com.oamanagersys.model.communicate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.communicate.entity.Group;
import com.oamanagersys.model.communicate.service.GroupService;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:25:59
 */
@Controller
@RequestMapping("/group")
public class GroupController {
	Message message = new Message();
	@Autowired
	private GroupService groupService;
	/**
	 * 联系人列表页面
	 * @return
	 */
	@RequestMapping("/grouplist")
	public String groupListPage(){
		return "pages/communicate/grouplist";
	}
	
	/**
	 * 添加组页面
	 * @return
	 */
	@RequestMapping("/addgroup")
	public ModelAndView addGroupPage(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/communicate/addgroup");
		return mav;
	}
	
	/**
	 * 添加组
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Message saveGroupPage(Group group,HttpServletRequest request){
		return groupService.insert(group, request);
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,List<Group>> groupList(Group group){
		List<Group> list = groupService.select(group);
		Map<String,List<Group>> map = new HashMap<String,List<Group>>();
		map.put("Rows", list);
		return map;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteGroup(String ids){
		int count = groupService.delete(ids);
		if(count > 0){
			message.isSuccess = true;
		}else{
			message.strMessage = "删除失败";
		}
		return message;
	}
}
