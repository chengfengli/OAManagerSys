package com.oamanagersys.model.communicate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.communicate.dao.LinkManDao;
import com.oamanagersys.model.communicate.entity.LinkMan;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:20:19
 */
@Service
public class LinkManService {
	Message message = new Message();
	@Autowired
	private LinkManDao linkManDao;
	
	/**
	 * 保存
	 * @param linkMan
	 * @param request
	 * @return
	 */
	public Message save(LinkMan linkMan,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		int count = 0;
		if(StringUtils.isBlank(linkMan.getName())){
			message.isSuccess = false;
			message.strMessage = "联系人名字不能为空";
			return message;
		}else if(linkMan.getGroupId() == 0){
			message.isSuccess = false;
			message.strMessage = "选择一个分组";
			return message;
		}else if(linkMan.getId() == 0){
			linkMan.setCreateTime(DateFormat.nowDateString());
			linkMan.setCreateUser(emp.getId());
			count = linkManDao.insert(linkMan);
		}else if(linkMan.getId() != 0){
			count = linkManDao.update(linkMan);
		}
		if(count > 0){
			message.isSuccess = true;
		}else{
			message.isSuccess = false;
			message.strMessage = "保存失败";
		}
		return message;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	public Message delete(String id){
		String[] ids = id.split(",");
		int count  = linkManDao.delete(ids);
		if(count > 0){
			message.isSuccess = true;
		}else{
			message.isSuccess = false;
			message.strMessage = "删除失败";
		}
		return message;
	}
	
	public List<LinkMan> select(LinkMan linkMan){
		List<LinkMan> list = linkManDao.select(linkMan);
		return list;
	}
}
