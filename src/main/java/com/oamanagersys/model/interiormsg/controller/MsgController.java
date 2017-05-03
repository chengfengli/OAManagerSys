package com.oamanagersys.model.interiormsg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 内部短信
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Controller
@RequestMapping("/interiormsg")
public class MsgController {
	
	/**
	 * 编写短息页面
	 * @return
	 */
	@RequestMapping("/writerMsg")
	public ModelAndView writerMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interiormsg/msg_add");
		return mav;
	}
	
	/**
	 * 已发送短息页面
	 * @return
	 */
	@RequestMapping("/sendedMsg")
	public ModelAndView sendedMsg(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("interiormsg/msg_sended");
		return mav;
	}
}
