package com.oamanagersys.model.department.dao;

import java.util.List;

import com.oamanagersys.model.department.entity.Position;

/**
 * 创建人： 李明
 * 时    间：2017年6月17日
 * 联    系：17310545652
 */
public interface PostDao {
	/**
	 * 获取角色信息
	 * @return
	 */
	public List<Position> getPsot();
	
	/**
	 * 通过id获取角色信息
	 * @return
	 */
	public List<Position> getPsotById(String positionId);
	/**
	 * 添加角色信息
	 * @param position
	 * @return
	 */
	public int insert(Position position);
	/**
	 * 修改角色信息
	 * @param position
	 * @return
	 */
	public int update(Position position);
}
