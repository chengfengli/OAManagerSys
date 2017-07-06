package com.oamanagersys.model.email.entity;

/**
 * 邮件实体类
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public class SearchEmail {
	//id
	private int id = 0;

	//标题
	private String title;
	
	//发送人名称
	private String sendUser;
	
	//发送人工号
	private int sendNo;

	//发送时间
	private String sendTime;
	
	//接收人号码
	private String acceptNo;
	
	//接收人名字
	private String acceptName;
	
	//阅读状态
	private int emailStatus = -1;
	
	//邮箱类型
	private int boxType;
	
	public int getSendNo() {
		return sendNo;
	}

	public void setSendNo(int sendNo) {
		this.sendNo = sendNo;
	}
	
	public int getBoxType() {
		return boxType;
	}

	public void setBoxType(int boxType) {
		this.boxType = boxType;
	}

	public int getAcceptStatus() {
		return emailStatus;
	}

	public void setAcceptStatus(int emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getAcceptNo() {
		return acceptNo;
	}
	
	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSendUser() {
		return sendUser;
	}

	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmailStatus() {
		return emailStatus;
	}

	public void setEmailStatus(int emailStatus) {
		this.emailStatus = emailStatus;
	}

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}
}
