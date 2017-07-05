package com.oamanagersys.model.email.entity;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.base.BaseEntity;

/**
 * 邮件实体类
 * 创建人： 李明
 * 时    间：2017年3月30日
 * 联    系：17310545652
 */
public class SearchEmail {
	//标题
	private String title;
	
	//发送人工号
	private String sendUser;
	
	//发送时间
	private String sendTime;
	
	//接收人
	private String acceptNo;
	
	//阅读状态
	private int acceptStatus;
	
	public int getAcceptStatus() {
		return acceptStatus;
	}

	public void setAcceptStatus(int acceptStatus) {
		this.acceptStatus = acceptStatus;
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
}
