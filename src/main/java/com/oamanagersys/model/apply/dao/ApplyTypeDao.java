package com.oamanagersys.model.apply.dao;

import java.util.List;

import com.oamanagersys.model.apply.entity.ApplyType;

/**
 * 申请类型
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午1:37:49
 */
public interface ApplyTypeDao {
	int insert(List<ApplyType> list);
	
	List<ApplyType> select(ApplyType applyType);
	
	int delete();
}
