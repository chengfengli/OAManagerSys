package com.oamanagersys.model.user.entity;

import com.oamanagersys.util.base.BaseEntity;

/**
 * 员工信息类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年6月15日 下午5:37:37
 */
public class Information extends BaseEntity {
	//性别
	private int sex;
	
	//住址
	private String address;
	
	//出生日期
	private String birthday;
	
	//身份证号
	private String idCardNo;
	
	//年龄
	private int age;
	
	//毕业学校
	private String graduationSchool;
	
	//学历
	private String education;
	
	//专业
	private String major;
	
	//政治面貌
	private int politics;
	
	//身高
	private int height;
	
	//体重
	private int weight;
	
	//手机号
	private String mobilePhone;
	
	//邮箱
	private String email;
	
	//婚姻状况:未婚、已婚、离异、丧偶
	private String maritalStatus;
	
	//有无子女 0：无，1：有
	private int children;
	
	//签名
	private String autograph;
	
	//个人说明
	private String explain;
	
	//兴趣爱好
	private String hobby;
	
	//禁忌
	private String taboo;
	
	//员工号
	private int empNo;
	
	//员工公司信息
	private Emp emp;

	public int getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = Integer.parseInt(sex);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = Integer.parseInt(age);
	}

	public String getGraduationSchool() {
		return graduationSchool;
	}

	public void setGraduationSchool(String graduationSchool) {
		this.graduationSchool = graduationSchool;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getPolitics() {
		return politics;
	}

	public void setPolitics(String politics) {
		this.politics = Integer.parseInt(politics);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = Integer.parseInt(height);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = Integer.parseInt(weight);;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = Integer.parseInt(children);
	}

	public String getAutograph() {
		return autograph;
	}

	public void setAutograph(String autograph) {
		this.autograph = autograph;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getTaboo() {
		return taboo;
	}

	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = Integer.parseInt(empNo);
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}
}
