package com.oamanagersys.model.interiormsg.entity;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.base.BaseEntity;

/**
 * 内部短信实体类
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public class MsgEntity extends BaseEntity {
	//内容
	private String content;
	
	//接收者号码
	private String acceptNo;
	
	//接收者名称
	private String acceptName;
	
	//发送者号码
	private int sendNo;
	
	//发送时间
	private String sendTime;
	
	//消息类型 0：草稿箱，1：收件箱，2：发件箱
	private int boxType;
	
	//是否删除 0：删除，1：没删除
	private int delete = 1;
	
	//阅读状态  0：未读，1：已读
	private int readStatus = 0;
	
	//阅读时间
	private String readTime;
	
	private Emp emp;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public int getSendNo() {
		return sendNo;
	}

	public void setSendNo(int sendNo) {
		this.sendNo = sendNo;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
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

	public int getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(int readStatus) {
		this.readStatus = readStatus;
	}

	public String getReadTime() {
		return readTime;
	}

	public void setReadTime(String readTime) {
		this.readTime = readTime;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
