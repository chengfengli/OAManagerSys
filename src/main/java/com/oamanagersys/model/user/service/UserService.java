package com.oamanagersys.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.user.dao.UserDao;
import com.oamanagersys.model.user.entity.Emp;

@Service
public class UserService {
	@Autowired
	private UserDao userMapper;
	
	public List<Emp> getAllEmp(){
		return userMapper.getAllEmp();
	}
	
	public int addUser(Emp user){
		return userMapper.addUser(user);
	}
	
}
