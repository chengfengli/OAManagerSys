package com.oamanagersys.model.email.dao;

import java.util.List;

import com.oamanagersys.model.email.entity.Email;
import com.oamanagersys.model.email.entity.SearchEmail;

/**
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public interface EmailDao {
	public int insert(List<Email> list);
	
	public List<Email> selectInbox(SearchEmail searchEmail);
}
