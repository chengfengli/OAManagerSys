package com.oamanagersys.model.notice.dao;

import java.util.List;

import com.oamanagersys.model.notice.entity.NoticeType;

public interface NoticeTypeDao {
	/**
	 * 添加
	 * @param noticeType
	 * @return
	 */
	int insert(NoticeType noticeType);
	
	/**
	 * 修改
	 * @param noticeType
	 * @return
	 */
	int update(NoticeType noticeType);
	
	/**
	 * 查询
	 * @param noticeType
	 * @return
	 */
	List<NoticeType> select(NoticeType noticeType);
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	int delete(String[] ids);
}
