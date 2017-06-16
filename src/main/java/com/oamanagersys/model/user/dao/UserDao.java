package com.oamanagersys.model.user.dao;

import java.util.List;

import com.oamanagersys.model.user.entity.Emp;

public interface UserDao {
	public List<Emp> getAllEmp();
	
	public int addUser(Emp emp);
}
