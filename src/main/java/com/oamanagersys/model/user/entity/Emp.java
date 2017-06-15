package com.oamanagersys.model.user.entity;

import java.util.Date;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 员工类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:11:34
 */
public class Emp extends BaseEntity {
	//登陆密码
	private String password;
	
	//部门编号
	private int depId;
	
	//职位编号
	private int positionId;
	
	//入职时间
	private Date entryTime;
	
	//试用期
	private int probationPeriod;
	
	//姓名
	private String name;
	
	//是否转正
	private int formal;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public int getPositionId() {
		return positionId;
	}

	public void setPositionId(int positionId) {
		this.positionId = positionId;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public int getProbationPeriod() {
		return probationPeriod;
	}

	public void setProbationPeriod(int probationPeriod) {
		this.probationPeriod = probationPeriod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getFormal() {
		return formal;
	}

	public void setFormal(int formal) {
		this.formal = formal;
	}
}
