package com.oamanagersys.model.department.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.department.dao.PostDao;
import com.oamanagersys.model.department.entity.Position;
import com.oamanagersys.util.format.DateFormat;

/**
 * 创建人： 李明
 * 时    间：2017年6月17日
 * 联    系：17310545652
 */
@Service
public class PostService {
	@Autowired
	private PostDao postDao;
	/**
	 * 查询职位
	 * @return
	 */
	public List<Position> getPsot(){
		List<Position> list = postDao.getPsot();
		return list;
	}
	
	/**
	 * 通过id获取角色信息
	 * @return
	 */
	public List<Position> getPsotById(String positionId){
		List<Position> list  = postDao.getPsotById(positionId);
		return list;
	}
	
	/**
	 * 通过id获取角色信息
	 * @return
	 */
	public List<Position> getPsotByDepId(int depId){
		List<Position> list  = postDao.getPsotByDepId(depId);
		return list;
	}
	
	/**
	 * 新增职位信息
	 * @param position
	 * @return
	 */
	public int insert(Position position){
		position.setCreateTime(DateFormat.newDateString());
		return postDao.insert(position);
	}
	
	/**
	 * 修改职位信息
	 * @param position
	 * @return
	 */
	public int update(Position position){
		position.setLastUpdateTime(DateFormat.newDateString());
		return postDao.update(position);
	}
	
	/**
	 * 修改职位信息
	 * @param position
	 * @return
	 */
	public int delete(String ids){
		return postDao.delete(ids.split(","));
	}
}
