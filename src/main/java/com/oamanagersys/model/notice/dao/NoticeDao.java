package com.oamanagersys.model.notice.dao;

import java.util.List;

import com.oamanagersys.model.notice.entity.Notice;
import com.oamanagersys.model.notice.entity.SearchNotice;

/**
 * 
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午2:25:47
 */
public interface NoticeDao {
	int insert(Notice notice);
	
	List<Notice> select_all(Notice notice);
	
	List<Notice> select_not_read(SearchNotice search);
	
	List<Notice> select_read(SearchNotice search);
	
	Notice selectNewNotice();
	
	int update(List<Notice> list);
	
	int logic_delete(List<Notice> list);
	
	int delete(String[] ids);
}
