package com.oamanagersys.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.user.dao.UserDao;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.md5.Md5;

@Service
public class UserService {
	@Autowired
	private UserDao userMapper;
	
	public List<Emp> getAllEmp(Emp emp){
		emp.setPassword(Md5.md5(emp.getPassword()));
		return userMapper.getAllEmp(emp);
	}
	
	public int addUser(Emp user){
		return userMapper.addUser(user);
	}
	
}
