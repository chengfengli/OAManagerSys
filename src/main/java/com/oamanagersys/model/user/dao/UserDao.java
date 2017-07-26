package com.oamanagersys.model.user.dao;

import java.util.List;

import com.oamanagersys.model.user.entity.Emp;

public interface UserDao {
	public List<Emp> getAllEmp(Emp emp);
	
	public List<Emp> getEmpById(String[] ids);
	
	public List<Emp> getEmp(Emp emp);
	
	public int addEmp(Emp emp);
	
	public int updateOnJob(String[] array);
	
	public int updateEmp(Emp emp);
	
	public int deleteEmp(String[] ids);
}
