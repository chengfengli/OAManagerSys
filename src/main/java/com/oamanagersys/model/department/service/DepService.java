package com.oamanagersys.model.department.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.department.dao.DepDao;
import com.oamanagersys.model.department.entity.Dep;
import com.oamanagersys.util.format.DateFormat;

/**
 * 创建人： 李明
 * 时    间：2017年6月17日
 * 联    系：17310545652
 */
@Service
public class DepService {
	@Autowired
	private DepDao depDao;
	/**
	 * 查询部门
	 * @param dep
	 * @return
	 */
	public List<Dep> getDep(Dep dep){
		List<Dep> list = depDao.getDep(dep);
		return list;
	}
	
	/**
	 * 添加部门
	 * @param dep
	 * @return
	 */
	public int addDep(Dep dep){
		dep.setCreateTime(DateFormat.newDateString());
		int count  = depDao.addDep(dep);
		return count;
	}
	/**
	 * 修改部门
	 * @param dep
	 * @return
	 */
	public int updateDep(Dep dep){
		dep.setLastUpdateTime(DateFormat.newDateString());
		int count  = depDao.updateDep(dep);
		return count;
	}
	/**
	 * 修改部门
	 * @param dep
	 * @return
	 */
	public int deleteDep(String ids){
		int count  = depDao.deleteDep(ids.split(","));
		return count;
	}
}
