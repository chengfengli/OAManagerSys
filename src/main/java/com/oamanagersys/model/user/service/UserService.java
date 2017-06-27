package com.oamanagersys.model.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.user.dao.UserDao;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.format.DateFormat;
import com.oamanagersys.util.md5.Md5;

@Service
public class UserService {
	@Autowired
	private UserDao userMapper;
	
	public List<Emp> getAllEmp(Emp emp){
		emp.setPassword(Md5.md5(emp.getPassword()));
		return userMapper.getAllEmp(emp);
	}
	/**
	 * 添加员工
	 * @param emp
	 * @return
	 */
	public int addEmp(Emp emp){
		emp.setPassword(Md5.md5("123456"));
		emp.setCreateTime(DateFormat.newDateString());
		emp.setOnJob(1);
		return userMapper.addEmp(emp);
	}
	/**
	 * 离职操作
	 * @param idStr
	 * @return
	 */
	public int updateOnJob(String idStr,int userId){
		String[] ids = idStr.split(",");
		int count  = userMapper.updateOnJob(ids);
		return count;
	}
	
}
