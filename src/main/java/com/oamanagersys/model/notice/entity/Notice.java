package com.oamanagersys.model.notice.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 通知公告实体类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午2:25:13
 */
public class Notice extends BaseEntity {
	//标题
	private String title;
	
	//格式
	private String format;
	
	//类型
	private NoticeType type;
	
	//类型Id
	private int typeId;
	
	//内容
	private String content;
	
	//状态
	private int status;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public NoticeType getType() {
		return type;
	}

	public void setType(NoticeType type) {
		this.type = type;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
