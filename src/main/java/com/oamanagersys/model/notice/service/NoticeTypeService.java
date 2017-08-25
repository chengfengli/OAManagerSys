package com.oamanagersys.model.notice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.notice.dao.NoticeTypeDao;
import com.oamanagersys.model.notice.entity.NoticeType;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

@Service
public class NoticeTypeService {
	Message message = new Message();
	@Autowired
	private NoticeTypeDao noticeTypeDao;
	
	/**
	 * 添加、修改
	 * @param noticeType
	 * @return
	 */
	public Message save(NoticeType noticeType,HttpServletRequest request){
		int userId = (Integer) request.getSession().getAttribute("userId");
		int count = 0;
		if(noticeType.getId() == 0){
			noticeType.setCreateUser(userId);
			noticeType.setCreateTime(DateFormat.nowDateString());
			count = noticeTypeDao.insert(noticeType);
		}else{
			noticeType.setUpdateUser(userId);
			noticeType.setLastUpdateTime(DateFormat.nowDateString());
			count = noticeTypeDao.update(noticeType);
		}
		if(count!=0){
			message.isSuccess = true;
			message.strMessage = "保存成功";
		}else{
			message.isSuccess = false;
			message.strMessage = "保存失败";
		}
		return message;
	}
	
	/**
	 * 查询
	 * @param noticeType
	 * @return
	 */
	public List<NoticeType> select(NoticeType noticeType){
		List<NoticeType> list = noticeTypeDao.select(noticeType);
		return list;
	}
	
	/**
	 * 删除
	 * @param noticeType
	 * @return
	 */
	public Message delete(String ids){
		int count = 0;
		String[] id = ids.split(",");
		count = noticeTypeDao.delete(id);
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
