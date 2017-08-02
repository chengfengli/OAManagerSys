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

import com.oamanagersys.model.apply.entity.Apply;
import com.oamanagersys.model.apply.service.ApplyService;
import com.oamanagersys.model.file.entity.FileEntity;
import com.oamanagersys.model.file.service.FileService;
import com.oamanagersys.model.notice.entity.Notice;
import com.oamanagersys.model.notice.entity.NoticeType;
import com.oamanagersys.model.notice.entity.SearchNotice;
import com.oamanagersys.model.notice.service.NoticeService;
import com.oamanagersys.model.notice.service.NoticeTypeService;
import com.oamanagersys.util.response.Message;

@Controller
@RequestMapping("notice")
public class NoticeController {
	Message message = new Message();
	
	@Autowired
	private NoticeService noticeService;
	@Autowired
	private NoticeTypeService noticeTypeService;
	@Autowired
	private FileService fileService;
	@Autowired
	private ApplyService applyService;
	
	/**
	 * 所有通知页面：用户
	 * @return
	 */
	@RequestMapping("/page/all_list")
	public ModelAndView allListPage(){
		ModelAndView mav = new ModelAndView("pages/notice/all_list");
		List<NoticeType> list = noticeTypeService.select(new NoticeType());
		mav.addObject("noticeTypes", list);
		return mav;
	}
	
	/**
	 * 查询用户所能看到的所有公告
	 * @param notice
	 * @return
	 */
	@RequestMapping("/all_list")
	@ResponseBody
	public Map<String,List<Notice>> select_read(SearchNotice search,HttpServletRequest request){
		List<Notice> list = noticeService.select_read(search,request);
		Map<String,List<Notice>> map = new HashMap<String,List<Notice>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 未读公告页面
	 * @return
	 */
	@RequestMapping("/page/unread_list")
	public ModelAndView sendedMsgPage(){
		ModelAndView mav = new ModelAndView("pages/notice/unread_list");
		List<NoticeType> list = noticeTypeService.select(new NoticeType());
		mav.addObject("noticeTypes", list);
		return mav;
	}
	
	/**
	 * 未读公告
	 * @param notice
	 * @return
	 */
	@RequestMapping("/not_read_list")
	@ResponseBody
	public Map<String,List<Notice>> select_not_read(SearchNotice search,HttpServletRequest request){
		List<Notice> list = noticeService.select_not_read(search,request);
		Map<String,List<Notice>> map = new HashMap<String,List<Notice>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 待审通知页面
	 * @return
	 */
	@RequestMapping("/page/careful_list")
	public String carefulMsgPage(){
		return "pages/notice/careful_list";
	}
	
	/**
	 * 待审核申请
	 * @param notice
	 * @return
	 */
	@RequestMapping("/careful_list")
	@ResponseBody
	public Map<String,List<Apply>> careful_list(Apply apply,HttpServletRequest request){
		int userId = (int)request.getSession().getAttribute("userId");
		apply.setApprover(userId);
		List<Apply> list = applyService.applylist(apply);
		Map<String,List<Apply>> map = new HashMap<String,List<Apply>>();
		map.put("Rows", list);
		return map;
	}
	
	/**
	 * 审核:同意
	 * @return
	 */
	@RequestMapping("/appro_agree")
	@ResponseBody
	public Message agree(String ids,Apply apply){
		if(StringUtils.isBlank(ids)){
			message.strMessage = "请选择要审核的申请";
		}else{
			apply.setStatus("a");
			message = applyService.update_appro(ids, apply);
		}
		return message;
	}
	
	/**
	 * 审核:拒绝
	 * @return
	 */
	@RequestMapping("/appro_disagree")
	@ResponseBody
	public Message disagree(String ids,Apply apply){
		if(StringUtils.isBlank(ids)){
			message.strMessage = "请选择要审核的申请";
		}else if(StringUtils.isBlank(apply.getOpinion())){
			message.strMessage = "请填写拒绝理由";
		}else{
			apply.setStatus("d");
			message = applyService.update_appro(ids, apply);
		}
		return message;
	}
	
	/**
	 * 新增通知页面
	 * @return
	 */
	@RequestMapping("/page/add_notice")
	public ModelAndView addNoticePage(){
		ModelAndView mav = new ModelAndView("pages/notice/add_notice");
		List<NoticeType> list = noticeTypeService.select(new NoticeType());
		mav.addObject("noticeTypes", list);
		return mav;
	}
	
	/**
	 * 新增通知
	 * @return
	 */
	@RequestMapping("/add_notice")
	@ResponseBody
	public Message addNotice(Notice notice,HttpServletRequest request){
		if(StringUtils.isBlank(notice.getTitle())){
			message.strMessage = "输入通知标题";
		}else if(notice.getTypeId()==5 && StringUtils.isBlank(notice.getDepId())){
			message.strMessage = "选择部门";
		}else{
			message = noticeService.save(notice, request);
		}
		return message;
	}
	
	/**
	 * 最新通知
	 * @return
	 */
	@RequestMapping("/newNotice")
	@ResponseBody
	public Notice selectNewNotice(){
		return noticeService.selectNewNotice();
	}
	
	/**
	 * 通知管理页面
	 * @return
	 */
	@RequestMapping("/page/notice_manager")
	public ModelAndView noticeManagerPage(){
		ModelAndView mav = new ModelAndView("pages/notice/notice_manager");
		List<NoticeType> list = noticeTypeService.select(new NoticeType());
		mav.addObject("noticeTypes", list);
		return mav;
	}
	
	/**
	 * 所有公告：管理
	 * @return
	 */
	@RequestMapping("/list_all")
	@ResponseBody
	public Map<String, List<Notice>> listAll(Notice notice){
		Map<String, List<Notice>> map = new HashMap<String, List<Notice>>();
		List<Notice> list = noticeService.select_all(notice);
		map.put("Rows", list);
		return map;
	}
	

	/**
	 * 详情
	 * @return
	 */
	@RequestMapping("/details")
	public ModelAndView detailsEmail(Notice notice,HttpServletRequest request){
		String userId = request.getSession().getAttribute("userId").toString();
		ModelAndView mav = new ModelAndView("pages/notice/details");
		List<Notice> list = noticeService.select_all(notice);
		if(list.size() > 0){
			notice = list.get(0);
			if(notice.getReader().indexOf(userId) == -1){
				noticeService.update(Integer.toString(notice.getId()), request);
			}
			String fileId = list.get(0).getFileId();
			FileEntity file = new FileEntity();
			file.setFileId(fileId);
			List<FileEntity> files = fileService.select(file);
			list.get(0).setList(files);
			mav.addObject("notice", list.get(0));
		}
		return mav;
	}
	
	/**
	 * 物理删除
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public Message delete(String ids){
		if(StringUtils.isBlank(ids)){
			message.isSuccess = false;
			message.strMessage = "选择要删除的数据";
		}else{
			message = noticeService.delete(ids);
		}
		return message;
	}
	/**
	 * 物理删除
	 * @return
	 */
	@RequestMapping("/logic_delete")
	@ResponseBody
	public Message logic_delete(String ids,HttpServletRequest request){
		if(StringUtils.isBlank(ids)){
			message.isSuccess = false;
			message.strMessage = "选择要删除的数据";
		}else{
			message = noticeService.logic_delete(ids,request);
		}
		return message;
	}
	
	/**
	 * 物理删除
	 * @return
	 */
	@RequestMapping("/readed")
	@ResponseBody
	public Message update(String ids,HttpServletRequest request){
		if(StringUtils.isBlank(ids)){
			message.isSuccess = false;
			message.strMessage = "选择要标记的数据";
		}else{
			message = noticeService.update(ids,request);
		}
		return message;
	}
}
