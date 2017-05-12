package com.oamanagersys.model.user.dao;

import java.util.List;

import com.oamanagersys.model.user.entity.User;

public interface UserDao {
	public List<User> getAllUser();
	
	public int addUser(User user);
}
