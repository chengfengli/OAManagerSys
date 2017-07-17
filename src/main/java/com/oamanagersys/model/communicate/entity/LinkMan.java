package com.oamanagersys.model.communicate.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 联系人实体类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月5日 上午11:19:02
 */
public class LinkMan extends BaseEntity{
	//分组编号
	private int groupId;
	
	//姓名
	private String name;
	
	//住址
	private String address;
	
	//手机
	private String mobile;
	
	//电话
	private String telephone;
	
	//QQ
	private String qq;
	
	//邮箱
	private String email;
	
	//其他
	private String other;
	
	//分组
	private Group group;

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}
	
}
