package com.oamanagersys.model.user.entity;

import java.util.List;

import com.oamanagersys.model.department.entity.Dep;
import com.oamanagersys.model.department.entity.Position;
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
	private String positionId;
	
	//入职时间
	private String entryTime;
	
	//试用期
	private int probationPeriod;
	
	//姓名
	private String name;
	
	//是否转正
	private int formal;
	
	//是否在职
	private int onJob;

	//部门
	private Dep dep;
	
	//职位
	private List<Position> position;

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

	public String getPositionId() {
		return positionId;
	}

	public void setPositionId(String positionId) {
		this.positionId = positionId;
	}

	public String getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(String entryTime) {
		this.entryTime = entryTime;
	}
	
	public int getOnJob() {
		return onJob;
	}

	public void setOnJob(int onJob) {
		this.onJob = onJob;
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
	
	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public List<Position> getPosition() {
		return position;
	}

	public void setPosition(List<Position> position) {
		this.position = position;
	}
}
