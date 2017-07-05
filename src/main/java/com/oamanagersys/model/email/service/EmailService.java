package com.oamanagersys.model.email.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.email.dao.EmailDao;
import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.model.email.entity.SearchEmail;
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
		List<Email> list = new ArrayList<Email>();
		String acceptNo = email.getAcceptNo();
		String acceptNos[] = acceptNo.split(";");
		for(int i=0;i<acceptNos.length;i++){
			Email e = new Email();
			e.setSendStatus(1);
			e.setTitle(email.getTitle());
			e.setContent(email.getContent());
			e.setSendTime(email.getSendTime());
			e.setSendStatus(email.getSendStatus());
			e.setSendNo(email.getSendNo());
			e.setAcceptNo(acceptNos[i]);
			e.setCreateUser(email.getCreateUser());
			e.setCreateTime(email.getCreateTime());
			list.add(e);
		}
		return emailDao.insert(list);
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
		List<Email> list = new ArrayList<Email>();
		String acceptNo = email.getAcceptNo();
		String acceptNos[] = acceptNo.split(";");
		for(int i=0;i<acceptNos.length;i++){
			Email e = email;
			e.setAcceptNo(acceptNos[i]);
			list.add(e);
		}
		return emailDao.insert(list);
	}
	
	/**
	 * 收件箱
	 * @param empNo
	 * @return
	 */
	public List<Email> selectInbox(SearchEmail searchEmail){
		return emailDao.selectInbox(searchEmail);
	}
	
	
}
