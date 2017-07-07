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
	public List<Position> getPsot(Position position);
	
	/**
	 * 通过id获取角色信息
	 * @return
	 */
	public List<Position> getPsotById(String[] positionId);
	/**
	 * 通过部门获取角色信息
	 * @param depId
	 * @return
	 */
	public List<Position> getPsotByDepId(int depId);
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
	/**
	 * 删除角色信息
	 * @param position
	 * @return
	 */
	public int delete(String[] ids);
}
