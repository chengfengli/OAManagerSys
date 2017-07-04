package com.oamanagersys.model.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.email.dao.EmailDao;
import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.util.format.DateFormat;

/**
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
@Service
public class EmailService {
	@Autowired
	private EmailDao emailDao;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 */
	public int send(Email email){
		email.setCreateTime(DateFormat.newDateString());
		//发送状态为已发送
		email.setSendStatus(1);
		email.setSendTime(DateFormat.newDateString());
		return emailDao.insert(email);
	}
	
	/**
	 * 存为草稿
	 * @param email
	 * @return
	 */
	public int draft(Email email){
		email.setCreateTime(DateFormat.newDateString());
		//发送状态为草稿
		email.setSendStatus(0);
		return emailDao.insert(email);
	}
	
	
}
