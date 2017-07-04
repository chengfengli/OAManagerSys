package com.oamanagersys.model.email.entity;

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
	
	//发送状态：1：已发送，0：草稿
	private int sendStatus;
	
	//接收状态：1：已读，0：未读
	private int acceptStatus = 0;
	
	//接收人
	private String acceptNo;
	
	//发送人工号
	private int sendNo;
	
	//发送时间
	private String sendTime;

	//发送人
	private Emp emp;
	
	//是否删除：1：删除，0：未删除
	private int delete = 0;

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

	public int getSendStatus() {
		return sendStatus;
	}

	public void setSendStatus(int sendStatus) {
		this.sendStatus = sendStatus;
	}

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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}
}
