package com.oamanagersys.model.department.entity;

import com.oamanagersys.util.base.BaseEntity;
/**
 * 角色实体
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:28:39
 */
public class Position extends BaseEntity {
	//角色编码
	private String positionCode;
	
	//角色名称
	private String positionName;
	
	//权限菜单:主菜单
	private String parentMenu;

	//权限菜单:子菜单
	private String childMenu;
	
	//部门编号
	private int depId;
	
	//部门
	private Dep dep;
	
	public String getParentMenu() {
		return parentMenu;
	}
	
	public void setParentMenu(String parentMenu) {
		this.parentMenu = parentMenu;
	}
	
	public String getChildMenu() {
		return childMenu;
	}

	public void setChildMenu(String childMenu) {
		this.childMenu = childMenu;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}
}
