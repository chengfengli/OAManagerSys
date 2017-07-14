package com.oamanagersys.model.interiormsg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.interiormsg.entity.MsgEntity;
import com.oamanagersys.model.interiormsg.entity.SearchMsg;
import com.oamanagersys.model.interiormsg.service.MsgService;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.model.user.service.UserService;
import com.oamanagersys.util.response.Message;

/**
 * 内部短信 controller
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/interiormsg")
public class MsgController {
	Message message = new Message();
	
	@Autowired
	private MsgService msgService;
	@Autowired
	private UserService userService;
	/**
	 * 编写短息页面
	 * @return
	 */
	@RequestMapping("/writerMsg")
	public ModelAndView writerMsg(String id,String type){
		ModelAndView mav = new ModelAndView();
		List<Emp> list = userService.getEmp(new Emp());
		mav.addObject("emps", list);
		mav.addObject("edit", false);
		if(StringUtils.isNotBlank(id)){	
			MsgEntity msg = msgService.selectById(Integer.parseInt(id));
			if(msg != null){
				if("forward".equals(type)){
					msg.setId(0);
					msg.setContent("转发："+msg.getContent());
				}
				mav.addObject("edit", true);
				mav.addObject("msg", msg);
			}
		}
		mav.setViewName("pages/interior_msg/interiormsg_add");
		return mav;
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/sendedMsg")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_sended");
		return mav;
	}
	
	/**
	 * 已接收短息页面
	 * @return
	 */
	@RequestMapping("/inboxMsg")
	public ModelAndView inboxMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_inbox");
		return mav;
	}
	
	/**
	 * 草稿页面
	 * @return
	 */
	@RequestMapping("/draftMsg")
	public ModelAndView draftMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("pages/interior_msg/interiormsg_draft");
		return mav;
	}
	
	/**
	 * 发送
	 * @return
	 */
	@RequestMapping("/sendMsg")
	@ResponseBody
	public Map<String,Object> sendMsg(MsgEntity msg,HttpServletRequest request){
		List<Emp> emps = userService.getEmpById(msg.getAcceptNo());
		String name ="";
		for(int i =0;i<emps.size();i++){
			name += emps.get(i).getName()+";";
		}
		msg.setAcceptName(name);
		int count = msgService.sendMsg(msg, request);
		Map<String,Object> map = new HashMap<String,Object>();
		if(count > 0){
			map.put("isSuccess", true);
			map.put("strMessage", "发送成功");
			map.put("acceptNo", msg.getAcceptNo());
			map.put("tips", "你有新的内部消息！");
		}else{
			map.put("isSuccess", false);
			map.put("strMessage", "发送失败");
		}
		return map;
	}
	
	/**
	 * 存草稿
	 * @return
	 */
	@RequestMapping("/draft")
	@ResponseBody
	public Message draftMsg(MsgEntity msg,HttpServletRequest request){
		List<Emp> emps = userService.getEmpById(msg.getAcceptNo());
		String name ="";
		for(int i =0;i<emps.size();i++){
			name += emps.get(i).getName()+";";
		}
		msg.setAcceptName(name);
		int count = msgService.draftMsg(msg, request);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "保存成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "保存失败";
		}
		return message;
	}
	
	/**
	 * 已发消息
	 * @return
	 */
	@RequestMapping("/sendList")
	@ResponseBody
	public Map<String,List<MsgEntity>> sendList(SearchMsg searchMsg,HttpServletRequest request){
		List<MsgEntity> list = msgService.select_sendlist(searchMsg, request);
		Map<String,List<MsgEntity>> map = new HashMap<String,List<MsgEntity>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 已接收消息
	 * @return
	 */
	@RequestMapping("/acceptList")
	@ResponseBody
	public Map<String,List<MsgEntity>> acceptList(SearchMsg searchMsg,HttpServletRequest request){
		List<MsgEntity> list = msgService.select_acceptlist(searchMsg, request);
		Map<String,List<MsgEntity>> map = new HashMap<String,List<MsgEntity>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 草稿消息
	 * @return
	 */
	@RequestMapping("/draftList")
	@ResponseBody
	public Map<String,List<MsgEntity>> draftList(SearchMsg searchMsg,HttpServletRequest request){
		List<MsgEntity> list = msgService.select_draftlist(searchMsg, request);
		Map<String,List<MsgEntity>> map = new HashMap<String,List<MsgEntity>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 发送、草稿详情
	 * @return
	 */
	@RequestMapping("/send/details")
	public ModelAndView send_details(int id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/interior_msg/send_details");
		MsgEntity msg = msgService.selectById(id);
		if(msg != null){
			mav.addObject("msg", msg);
		}
		return mav;
	}
	/**
	 * 接收详情
	 * @return
	 */
	@RequestMapping("/accept/details")
	public ModelAndView accept_details(int id,HttpServletRequest request){
		ModelAndView mav = new ModelAndView("pages/interior_msg/accept_details");
		MsgEntity msg = msgService.selectById(id);
		if(msg.getReadStatus() == 0){
			msgService.update_read(Integer.toString(id));
		}
		if(msg != null){
			mav.addObject("msg", msg);
		}
		return mav;
	}
	
	/**
	 * 删除消息
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(String ids){
		int count = msgService.delete(ids);
		if(count > 0){
			message.isSuccess = true;
			message.strMessage = "删除成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "删除失败";
		}
		return message;
	}
	/**
	 * 标记已读
	 * @param id
	 * @return
	 */
	@RequestMapping("/read")
	@ResponseBody
	public Message read(String ids){
		int count = msgService.update_read(ids);
		if(count >= 0){
			message.isSuccess = true;
		}
		return message;
	}
}
