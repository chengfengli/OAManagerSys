package com.oamanagersys.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.user.dao.UserDao;
import com.oamanagersys.model.user.entity.User;

@Service
public class UserService {
	@Autowired
	private UserDao userMapper;
	
	public List<User> getAllUser(){
		return userMapper.getAllUser();
	}
	
	public int addUser(User user){
		return userMapper.addUser(user);
	}
	
}
