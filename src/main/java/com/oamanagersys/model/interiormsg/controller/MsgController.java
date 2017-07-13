package com.oamanagersys.model.interiormsg.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.interiormsg.entity.MsgEntity;
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
	public ModelAndView writerMsg(){
		ModelAndView mav = new ModelAndView();
		List<Emp> list = userService.getEmp(new Emp());
		mav.addObject("emps", list);
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
}
