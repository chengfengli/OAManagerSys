package com.oamanagersys.model.department.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oamanagersys.model.department.dao.PostDao;
import com.oamanagersys.model.department.entity.Position;

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
	 * 新增职位信息
	 * @param position
	 * @return
	 */
	public int insert(Position position){
		position.setCreateTime(new Date());
		return postDao.insert(position);
	}
	
	/**
	 * 修改职位信息
	 * @param position
	 * @return
	 */
	public int update(Position position){
		position.setLastUpdateTime(new Date());
		return postDao.update(position);
	}
}
