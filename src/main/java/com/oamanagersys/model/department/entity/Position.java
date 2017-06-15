package com.oamanagersys.model.department.entity;

import com.oamanagersys.model.user.entity.Emp;
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
	
	//权限菜单
	private String menu;
	
	//部门编号
	private int depId;
	
	private Emp emp;

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
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

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
	}
}
