package com.oamanagersys.util.base;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.oamanagersys.model.user.entity.Emp;

/**
 * 基类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:04:49
 */
public class BaseEntity {
	private int id;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm")
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
	
	public void setCreate(Emp create) {
		this.create = create;
	}
	
	public Emp getUpdate() {
		return update;
	}
	
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
	@DateTimeFormat(pattern = "yyyy-MM-dd HH-mm")
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
