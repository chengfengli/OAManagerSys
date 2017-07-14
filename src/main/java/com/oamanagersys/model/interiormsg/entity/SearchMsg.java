package com.oamanagersys.model.interiormsg.entity;

/**
 * 内部短信搜索类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年7月14日 上午11:12:26
 */
public class SearchMsg {
	private String empName;
	
	private String time;
	
	private int sendNo;
	
	private String acceptNo;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getEmpNo() {
		return sendNo;
	}

	public void setEmpNo(int sendNo) {
		this.sendNo = sendNo;
	}

	public int getSendNo() {
		return sendNo;
	}

	public void setSendNo(int sendNo) {
		this.sendNo = sendNo;
	}

	public String getAcceptNo() {
		return acceptNo;
	}

	public void setAcceptNo(String acceptNo) {
		this.acceptNo = acceptNo;
	}
}
