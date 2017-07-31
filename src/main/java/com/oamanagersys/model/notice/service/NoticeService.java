package com.oamanagersys.model.notice.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.notice.dao.NoticeDao;
import com.oamanagersys.model.notice.entity.Notice;
import com.oamanagersys.model.notice.entity.SearchNotice;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

@Service
public class NoticeService {
	Message message = new Message();
	
	@Autowired
	private NoticeDao noticeDao;
	
	/**
	 * 添加通知公告
	 * @param notice
	 * @param request
	 * @return
	 */
	public Message save(Notice notice,HttpServletRequest request){
		int userId = (int)request.getSession().getAttribute("userId");
		notice.setCreateTime(DateFormat.getDateTimeString());
		notice.setCreateUser(userId);
		notice.setDeletes("");
		notice.setReader("");
		int count = noticeDao.insert(notice);
		if(count != 0){
			message.isSuccess = true;
			message.strMessage = "添加成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "添加失败";
		}
		return message;
	}
	
	/**
	 * 所有：管理
	 * @param notice
	 * @return
	 */
	public List<Notice> select_all(Notice notice){
		List<Notice> list = noticeDao.select_all(notice);
		return list;
	}
	
	/**
	 * 查询用户所能看到的所有公告
	 * @param notice
	 * @return
	 */
	public List<Notice> select_read(SearchNotice search,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		search.setDepId(Integer.toString(emp.getDepId()));
		search.setUserId(Integer.toString(emp.getId()));
		List<Notice> list = noticeDao.select_read(search);
		return list;
	}
	
	/**
	 * 未读公告
	 * @param notice
	 * @return
	 */
	public List<Notice> select_not_read(SearchNotice search,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		search.setDepId(Integer.toString(emp.getDepId()));
		search.setUserId(Integer.toString(emp.getId()));
		List<Notice> list = noticeDao.select_not_read(search);
		return list;
	}
	
	
	/**
	 * 最新公告
	 * @return
	 */
	public Notice selectNewNotice(){
		return noticeDao.selectNewNotice();
	}
	
	/**
	 * 标记已读
	 * @param notice
	 * @return
	 */
	public Message update(String ids,HttpServletRequest request){
		String[] id = ids.split(",");
		int userId = (int)request.getSession().getAttribute("userId");
		List<Notice> list = new ArrayList<Notice>();
		for(int i=0;i<id.length;i++){
			Notice ncotice = new Notice();
			ncotice.setId(Integer.parseInt(id[i]));
			ncotice.setCreateUser(userId);
			list.add(ncotice);
		}
		int count = noticeDao.update(list);
		if(count != 0){
			message.isSuccess = true;
			message.strMessage = "标记成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "标记失败";
		}
		return message;
	}
	
	/**
	 * 物理删除
	 * @param notice
	 * @return
	 */
	public Message delete(String ids){
		String[] id = ids.split(",");
		int count = noticeDao.delete(id);
		if(count != 0){
			message.isSuccess = true;
			message.strMessage = "删除成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "删除失败";
		}
		return message;
	}

	/**
	 * 逻辑删除
	 * @param notice
	 * @return
	 */
	public Message logic_delete(String ids, HttpServletRequest request) {
		int userId = (int)request.getSession().getAttribute("userId");
		String[] id = ids.split(",");
		List<Notice> list = new ArrayList<Notice>();
		for(int i=0;i<id.length;i++){
			Notice ncotice = new Notice();
			ncotice.setId(Integer.parseInt(id[i]));
			ncotice.setCreateUser(userId);
			list.add(ncotice);
		}
		int count = noticeDao.logic_delete(list);
		if(count != 0){
			message.isSuccess = true;
			message.strMessage = "删除成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "删除失败";
		}
		return message;
	}
}
