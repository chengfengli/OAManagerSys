package com.oamanagersys.model.notice.entity;

import java.util.List;

import com.oamanagersys.model.department.entity.Dep;
import com.oamanagersys.model.file.entity.FileEntity;
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
	
	//格式：普通
	private String format;
	
	//类型
	private NoticeType type;
	
	//类型Id
	private int typeId;
	
	//内容
	private String content;
	
	//状态：存在用户的编号，表示该用户已读，否则未读
	private String status;
	
	//部门id
	private String depId;
	
	//部门
	private List<Dep> depList;
	
	//附件
	private String fileId;
	
	private List<FileEntity> list;
	
	//删除
	private String deletes;
	
	//已查看过的人
	private String reader;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public List<FileEntity> getList() {
		return list;
	}

	public void setList(List<FileEntity> list) {
		this.list = list;
	}

	public String getDepId() {
		return depId;
	}

	public void setDepId(String depId) {
		this.depId = depId;
	}

	public List<Dep> getDepList() {
		return depList;
	}

	public void setDepList(List<Dep> depList) {
		this.depList = depList;
	}

	public String getDeletes() {
		return deletes;
	}

	public void setDeletes(String deletes) {
		this.deletes = deletes;
	}

	public String getReader() {
		return reader;
	}

	public void setReader(String reader) {
		this.reader = reader;
	}
}
