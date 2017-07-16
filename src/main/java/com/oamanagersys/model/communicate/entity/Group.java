package com.oamanagersys.model.communicate.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 分组实体类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:17:57
 */
public class Group extends BaseEntity{
	private String groupCode;
	
	private String groupName;

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode.toUpperCase();
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

}
