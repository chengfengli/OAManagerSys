package com.oamanagersys.model.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.model.user.entity.Information;
import com.oamanagersys.model.user.service.InformationService;
import com.oamanagersys.util.response.Message;

/**
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月30日 上午11:52:45
 */
@Controller
@RequestMapping("/infor")
public class InformationController {
	Message msg = new Message();
	@Autowired
	private InformationService inforService;
	
	/**
	 * 编辑员工基本信息页面
	 * @return
	 */
	@RequestMapping("/editinfomation")
	public ModelAndView infoMationPage(Information infor,HttpServletRequest request){
		Emp currentUser = (Emp)request.getSession().getAttribute("user");
		if(infor.getEmpNo() == 0){
			infor = inforService.inforByEmpNo(currentUser.getId());
		}else{
			infor = inforService.inforByEmpNo(infor.getEmpNo());
		}
		ModelAndView mav = new ModelAndView("pages/manageset/editinfomation");
		mav.addObject("infor", infor);
		if(infor.getEmpNo() == currentUser.getId()){
			mav.addObject("view", true);
		}else{
			mav.addObject("view", false);
		}
		return mav;
	}
	/**
	 * 编辑员工基本信息
	 * @param infor
	 * @param request
	 * @return
	 */
	@RequestMapping("/editInfor")
	@ResponseBody
	public Message editInfor(Information infor,HttpServletRequest request){
		Emp currentUser = (Emp)request.getSession().getAttribute("user");
		if(infor.getId() ==0){
			infor.setCreateUser(currentUser.getId());
			infor.setEmpNo(currentUser.getId()+"");
			if(inforService.insertInfor(infor)>0){
				msg.isSuccess = true;
				msg.strMessage = "添加成功";
			}else{
				msg.strMessage = "添加失败";
				msg.isSuccess = false;
			}
		}else{
			infor.setUpdateUser(currentUser.getId());
			if(inforService.updateInfor(infor)>0){
				msg.isSuccess = true;
				msg.strMessage = "修改成功";
			}else{
				msg.strMessage = "修改失败";
				msg.isSuccess = false;
			}
		}
		return msg;
	}
}
