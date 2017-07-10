package com.oamanagersys.model.email.entity;

import java.util.List;

import com.oamanagersys.model.file.entity.FileEntity;
import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.base.BaseEntity;

/**
 * 邮件实体类
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public class Email extends BaseEntity {
	//标题
	private String title;
	
	//内容
	private String content;
	
	//抄送
	private String copyer;
	
	//接收号码
	private String acceptNo;
	
	//接收者名字
	private String acceptName;
	
	//发送者
	private int sendNo;
	
	private Emp emp;
	
	//邮件状态 0：未读，1：已读，2：回复，3：转发，4：全部转发
	private int emailStatus = -1;
	
	//邮箱类型 0：草稿箱，1：收件箱，2：发件箱，3:垃圾箱
	private int boxType;
	
	//是否删除 0：删除，1：没删除
	private int delete = 1;
	
	//发送时间
	private String sendTime;
	
	//阅读时间
	private String readTime;
	
	//附件
	private String fileId;
	
	private List<FileEntity> list;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCopyer() {
		return copyer;
	}

	public void setCopyer(String copyer) {
		this.copyer = copyer;
	}

	public int getSendNo() {
		return sendNo;
	}

	public void setSendNo(int sendNo) {
		this.sendNo = sendNo;
	}
	
	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(int emailStatus) {
		this.emailStatus = emailStatus;
	}

	public int getBoxType() {
		return boxType;
	}

	public void setBoxType(int boxType) {
		this.boxType = boxType;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public String getAcceptNo() {
		return acceptNo;
	}

	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
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
}
