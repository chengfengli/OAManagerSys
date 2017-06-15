package com.oamanagersys.util.base;

import java.util.Date;

/**
 * 基类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:04:49
 */
public class BaseEntity {
	private int id;
	private Date createTime;
	private int createUser;
	private Date lastUpdateTime;
	private int updateUser;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getCreateUser() {
		return createUser;
	}
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public int getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(int updateUser) {
		this.updateUser = updateUser;
	}
}
