package com.oamanagersys.model.department.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 部门实体
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:18:45
 */
public class Dep extends BaseEntity {
	//部门编码
	private String depCode;
	
	//部门名称
	private String depName;
	
	//描述
	private String describe;

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode.toUpperCase();
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
