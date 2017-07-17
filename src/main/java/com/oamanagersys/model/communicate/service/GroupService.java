package com.oamanagersys.model.communicate.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.communicate.dao.GroupDao;
import com.oamanagersys.model.communicate.entity.Group;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.response.Message;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:25:46
 */
@Service
public class GroupService {
	Message message = new Message();
	@Autowired
	private GroupDao groupDao;
	/**
	 * 保存分组
	 * @param group
	 * @param request
	 * @return
	 */
	public Message insert(Group group,HttpServletRequest request){
		Emp emp = (Emp)request.getSession().getAttribute("user");
		if(StringUtils.isBlank(group.getGroupCode())){
			message.isSuccess = false;
			message.strMessage = "编码不能为空";
			return message;
		}
		if(StringUtils.isBlank(group.getGroupName())){
			message.isSuccess = false;
			message.strMessage = "组名不能为空";
			return message;
		}
		int count = 0;
		if(group.getId() != 0){
			group.setLastUpdateTime(DateFormat.newDateString());
			group.setUpdateUser(emp.getId());
			count = groupDao.update(group);
		}else{
			group.setCreateTime(DateFormat.newDateString());
			group.setCreateUser(emp.getId());
			count = groupDao.insert(group);
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
	 * 查询所有分组
	 * @param group
	 * @return
	 */
	public List<Group> select(Group group){
		return groupDao.select(group);
	}
	
	public int delete(String id){
		String[] ids = id.split(",");
		return groupDao.delete(ids);
	}
	
	
}
