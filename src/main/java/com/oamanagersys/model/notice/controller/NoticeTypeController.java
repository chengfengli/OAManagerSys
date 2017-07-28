package com.oamanagersys.model.notice.controller;

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

import com.oamanagersys.model.notice.entity.NoticeType;
import com.oamanagersys.model.notice.service.NoticeTypeService;
import com.oamanagersys.util.response.Message;

@Controller
@RequestMapping("noticeType")
public class NoticeTypeController {
	Message message = new Message();
	@Autowired
	private NoticeTypeService noticeTypeService;
	/**
	 * 类型编辑页面
	 * @return
	 */
	@RequestMapping("/page/noticeType")
	public ModelAndView noticeType(NoticeType noticeType){
		ModelAndView mav = new ModelAndView("pages/notice/addNoticeType");
		if(noticeType.getId() != 0){
			List<NoticeType> list = noticeTypeService.select(noticeType);
			if(list.size() > 0){
				noticeType = list.get(0);
				mav.addObject("noticeType", noticeType);
			}
		}
		return mav;
	}
	
	/**
	 * 类型列表页面
	 * @return
	 */
	@RequestMapping("/page/list")
	public ModelAndView noticeTypeList(){
		ModelAndView mav = new ModelAndView("pages/notice/noticeTypelist");
		return mav;
	}
	
	/**
	 * 类型
	 * @return
	 */
	@RequestMapping("/list")
	@ResponseBody
	public Map<String,List<NoticeType>> list(NoticeType noticeType){
		List<NoticeType> list = noticeTypeService.select(noticeType);
		Map<String,List<NoticeType>> map = new HashMap<String,List<NoticeType>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 保存类型
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public Message sendedMsg(NoticeType noticeType,HttpServletRequest request){
		if(StringUtils.isBlank(noticeType.getTypeCode())){
			message.isSuccess = false;
			message.strMessage = "编码不能为空";
		}else if(StringUtils.isBlank(noticeType.getTypeName())){
			message.isSuccess = false;
			message.strMessage = "名称不能为空";
		}else{
			message = noticeTypeService.save(noticeType, request);
		}
		return message;
	}
	
	/**
	 * 删除
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(String ids){
		if(StringUtils.isBlank(ids)){
			message.isSuccess = false;
			message.strMessage = "请选择要删除的数据";
		}else{
			message = noticeTypeService.delete(ids);
		}
		return message;
	}
	
	
}
