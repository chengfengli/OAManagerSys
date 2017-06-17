package com.oamanagersys.model.department.dao;

import java.util.List;

import com.oamanagersys.model.department.entity.Dep;

/**
 * 创建人： 李明
 * 时    间：2017年6月17日
 * 联    系：17310545652
 */
public interface DepDao {
	//查询部门
	public List<Dep> getDep(Dep dep);
	
	//添加部门
	public int addDep(Dep dep);
	
	//添加部门
	public int updateDep(Dep dep);
	
	//添加部门
	public int deleteDep(Dep dep);
}
