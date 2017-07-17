package com.oamanagersys.model.communicate.dao;

import java.util.List;

import com.oamanagersys.model.communicate.entity.LinkMan;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:20:26
 */
public interface LinkManDao {
	public int insert(LinkMan linkMan);
	
	public int delete(String[] id);
	
	public int update(LinkMan linkMan);
	
	public List<LinkMan> select(LinkMan linkMan);
}
