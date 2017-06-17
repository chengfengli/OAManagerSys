package com.oamanagersys.util.base;

import java.util.Date;

import com.oamanagersys.model.user.entity.Emp;

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
	private Emp create;
	private Emp update;
	/**
	 * @return the create
	 */
	public Emp getCreate() {
		return create;
	}
	/**
	 * @param create the create to set
	 */
	public void setCreate(Emp create) {
		this.create = create;
	}
	/**
	 * @return the update
	 */
	public Emp getUpdate() {
		return update;
	}
	/**
	 * @param update the update to set
	 */
	public void setUpdate(Emp update) {
		this.update = update;
	}
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
