package com.oamanagersys.model.apply.entity;
/**
 * 申请类型
 * @author	李明
 * @createtime	2017年8月1日 上午11:52:55
 */
public class ApplyType {
	private int id;
	
	private String typeCode;
	
	private String typeName;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
