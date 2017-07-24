package com.oamanagersys.model.notice.eitity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 通知公告类型
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午2:25:13
 */
public class NoticeType extends BaseEntity{
	//类型编码
	public String typeCode;
	//类型名称
	public String typeName;

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
}
