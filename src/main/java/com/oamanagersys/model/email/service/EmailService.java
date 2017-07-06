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
		email.setSendTime(DateFormat.newDateString());
		email.setBoxType(2);
		List<Email> list = new ArrayList<Email>();
		list.add(email);
		String acceptNo = email.getAcceptNo();
		String acceptNos[] = acceptNo.split(";");
		String acceptName = email.getAcceptName();
		String acceptNames[] = acceptName.split(";");
		for(int i=0;i<acceptNos.length;i++){
			Email e = new Email();
			e.setTitle(email.getTitle());
			e.setContent(email.getContent());
			e.setSendTime(email.getSendTime());
			e.setSendNo(email.getSendNo());
			e.setCreateUser(email.getCreateUser());
			e.setCreateTime(email.getCreateTime());
			e.setAcceptNo(acceptNos[i]);
			e.setAcceptName(acceptNames[i]);
			e.setBoxType(1);
			e.setCopyer(email.getCopyer());
			e.setEmailStatus(0);
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
		//邮件状态为草稿
		email.setBoxType(0);
		List<Email> list = new ArrayList<Email>();
		list.add(email);
		return emailDao.insert(list);
	}
	
	/**
	 * 收件箱
	 * @param empNo
	 * @return
	 */
	public List<Email> selectInbox(SearchEmail searchEmail){
		if(searchEmail.getId() == 0){
			searchEmail.setBoxType(1);
		}else{
			searchEmail.setBoxType(-1);
		}
		return emailDao.selectInbox(searchEmail);
	}
	
	/**
	 * 标记为已读
	 * @param ids
	 * @return
	 */
	public int updateReaded(String ids){
		String[]  id = ids.split(",");
		return emailDao.update_readed(id);
	}
	
	/**
	 * 删除邮件
	 * @param ids
	 * @return
	 */
	public int deleteEmail(String ids){
		String[]  id = ids.split(",");
		return emailDao.delete_email(id);
	}
	
	/**
	 * 发件箱
	 * @param searchEmail
	 * @return
	 */
	public List<Email> selectOutbox(SearchEmail searchEmail){
		if(searchEmail.getId() == 0){
			searchEmail.setBoxType(2);
		}else{
			searchEmail.setBoxType(-1);
		}
		return emailDao.selectInbox(searchEmail);
	}
	
	/**
	 * 草稿箱
	 * @param searchEmail
	 * @return
	 */
	public List<Email> selectDrart(SearchEmail searchEmail){
		searchEmail.setBoxType(0);
		return emailDao.selectInbox(searchEmail);
	}
}
