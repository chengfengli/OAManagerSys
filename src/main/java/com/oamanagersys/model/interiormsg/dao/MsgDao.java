package com.oamanagersys.model.interiormsg.dao;

import java.util.List;

import com.oamanagersys.model.interiormsg.entity.MsgEntity;

/**
 * 内部短信
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public interface MsgDao {
	public int insert(List<MsgEntity> list);
}
