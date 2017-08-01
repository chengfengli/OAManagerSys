package com.oamanagersys.model.apply.controller;

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

import com.oamanagersys.model.apply.entity.Apply;
import com.oamanagersys.model.apply.entity.ApplyType;
import com.oamanagersys.model.apply.service.ApplyService;
import com.oamanagersys.model.apply.service.ApplyTypeService;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午3:15:50
 */
@Controller
@RequestMapping("apply")
public class ApplyController {
	Message message = new Message();
	@Autowired
	private ApplyService applyService;
	@Autowired
	private ApplyTypeService applyTypeService;
	/**
	 * 申请登记列表页面
	 * @return
	 */
	@RequestMapping("/page/applylist")
	public ModelAndView GooutListPage(){
		ModelAndView mav = new ModelAndView("pages/kaoqin/applylist");
		List<ApplyType> list = applyTypeService.list();
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * 申请页面
	 * @return
	 */
	@RequestMapping("/page/apply")
	public ModelAndView applyPage(){
		ModelAndView mav = new ModelAndView("pages/kaoqin/apply");
		List<ApplyType> list = applyTypeService.list();
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * 发起申请
	 * @param apply
	 * @param request
	 * @return
	 */
	@RequestMapping("apply")
	@ResponseBody
	public Message apply(Apply apply,HttpServletRequest request){
		if(StringUtils.isBlank(apply.getStartTime())){
			message.strMessage = "请选择开始时间";
		}else if(StringUtils.isBlank(apply.getEndTime())){
			message.strMessage = "请选择结束时间";
		}else if(apply.getLongHours()<0.5){
			message.strMessage = "时长必须大于0.5小时";
		}else if(StringUtils.isBlank(apply.getTypeCode())){
			message.strMessage = "请选择类型";
		}else if(apply.getApprover()==0){
			message.strMessage = "请选择审批人";
		}else if("evection".equals(apply.getTypeCode()) && StringUtils.isBlank(apply.getAddress())){
			message.strMessage = "请填写出差地点";
		}else if(StringUtils.isBlank(apply.getReason())){
			message.strMessage = "请填写事由";
		}else{
			message = applyService.apply(apply, request);
		}
		return message;
	}
	
	@RequestMapping("applylist")
	@ResponseBody
	public Map<String,List<Apply>> applylist(Apply apply){
		Map<String,List<Apply>> map = new HashMap<String,List<Apply>>();
		List<Apply> list = applyService.applylist(apply);
		map.put("Rows", list);
		return map;
	}
}
