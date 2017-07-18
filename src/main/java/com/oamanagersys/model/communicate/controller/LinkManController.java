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
import com.oamanagersys.model.communicate.entity.LinkMan;
import com.oamanagersys.model.communicate.service.GroupService;
import com.oamanagersys.model.communicate.service.LinkManService;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:20:15
 */
@Controller
@RequestMapping("/linkman")
public class LinkManController {
	Message message = new Message();
	@Autowired
	private LinkManService linkManService;
	@Autowired
	private GroupService groupService;
	/**
	 * 联系人列表页面
	 * @return
	 */
	@RequestMapping("/linkmanlist")
	public String linkManListPage(){
		return "pages/communicate/linkmanlist";
	}
	
	/**
	 * 添加页面
	 * @return
	 */
	@RequestMapping("/addlinkman")
	public ModelAndView addLinkManPage(LinkMan linkMan,HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/communicate/addlinkman");
		List<Group> groups = groupService.select(new Group());
		if(linkMan.getId() != 0){
			List<LinkMan> list = linkManService.select(linkMan);
			if(list.size() > 0){
				mav.addObject("linkMan", list.get(0));
			}
		}else{
			
		}
		mav.addObject("groups", groups);
		return mav;
	}
	
	/**
	 * 添加联系人
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Message saveLinkMan(LinkMan linkMan,HttpServletRequest request){
		return linkManService.save(linkMan, request);
	}
	
	/**
	 * 联系人列表
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,List<LinkMan>> listLinkMan(LinkMan linkMan){
		List<LinkMan> list  = linkManService.select(linkMan);
		Map<String,List<LinkMan>> map = new HashMap<String,List<LinkMan>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 联系人列表
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteLinkMan(String ids){
		return linkManService.delete(ids);
	}
}
