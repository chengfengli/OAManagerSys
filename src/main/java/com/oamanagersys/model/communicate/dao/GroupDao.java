package com.oamanagersys.model.communicate.dao;

import java.util.List;

import com.oamanagersys.model.communicate.entity.Group;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:25:22
 */
public interface GroupDao {
	public int insert(Group group);
	
	public List<Group> select(Group group);
	
	public int delete(String[] id);
}
