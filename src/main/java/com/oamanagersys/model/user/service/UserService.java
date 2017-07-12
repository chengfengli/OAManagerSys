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
	private UserDao userDao;
	
	/*级联查询*/
	public List<Emp> getAllEmp(Emp emp){
		emp.setPassword(Md5.md5(emp.getPassword()));
		return userDao.getAllEmp(emp);
	}
	
	public List<Emp> getEmpById(String id){
		String[] ids = id.split(";");
		return userDao.getEmpById(ids);
	}
	
	/*非级联*/
	public List<Emp> getEmp(Emp emp){
		emp.setPassword(Md5.md5(emp.getPassword()));
		return userDao.getEmp(emp);
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
		return userDao.addEmp(emp);
	}
	/**
	 * 离职操作
	 * @param idStr
	 * @return
	 */
	public int updateOnJob(String idStr,int userId){
		String[] ids = idStr.split(",");
		int count  = userDao.updateOnJob(ids);
		return count;
	}
	/**
	 * 修改员工信息
	 * @param emp
	 * @return
	 */
	public int updateEmp(Emp emp){
		return userDao.updateEmp(emp);
	}
	/**
	 * 删除员工
	 * @param id 员工工号
	 * @return
	 */
	public int deleteEmp(int id){
		return userDao.deleteEmp(id);
	}
	
}
