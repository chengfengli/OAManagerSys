package com.oamanagersys.model.apply.dao;

import java.util.List;

import com.oamanagersys.model.apply.entity.Apply;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午2:54:30
 */
public interface ApplyDao {
	/**
	 * 申请
	 * @param apply
	 * @return
	 */
	int insert_apply(Apply apply);
	
	/**
	 * 查询
	 * @param apply
	 * @return
	 */
	List<Apply> select(Apply apply);
	
	/**
	 * 审核
	 * @param apply
	 * @return
	 */
	int update_appro(List<Apply> apply);
}
