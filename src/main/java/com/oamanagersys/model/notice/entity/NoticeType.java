package com.oamanagersys.model.notice.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 通知公告类型
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午2:25:13
 */
public class NoticeType extends BaseEntity{
	//类型编码
	private String typeCode;
	//类型名称
	private String typeName;
	//描述
	private String describe;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode.toUpperCase();
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
}
