package com.oamanagersys.model.interiormsg.dao;

import java.util.List;

import com.oamanagersys.model.interiormsg.entity.MsgEntity;
import com.oamanagersys.model.interiormsg.entity.SearchMsg;

/**
 * 内部短信
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public interface MsgDao {
	public int insert(List<MsgEntity> list);
	
	public List<MsgEntity> select_sendlist(SearchMsg searchMsg);
	
	public List<MsgEntity> select_acceptlist(SearchMsg searchMsg);
	
	public List<MsgEntity> select_draftlist(SearchMsg searchMsg);
	
	public List<MsgEntity> selectById(int id);
	
	public int delete(String[] id);
	
	public int update_read(String[] id);
	
	public int update_msg(MsgEntity msg);
}
