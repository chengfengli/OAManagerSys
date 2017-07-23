package com.oamanagersys.model.kaoqin.entity;

import com.oamanagersys.model.user.entity.Emp;

/**
 * 考勤登记实体类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年5月4日 下午3:37:03
 */
public class Kaoqin {
	//id
	private int id;
	
	//员工号
	private int empNo;
	
	//员工
	private Emp emp;
	
	//日期
	private String day;
	
	//月份
	private String yearMonth;
	
	//星期
	private String weekDay;
	
	//签到时间
	private String signInTime;
	
	//签退时间
	private String signOutTime;
	
	//标准工时
	private int standardWorkTime=8;
	
	//实际工时
	private double actualWorkTime;
	
	//加班时长
	private double overTimeLong;
	
	//迟到时长
	private double lateTimeLong;
	
	//早退时长
	private double leaveEarlyTimeLong;
	
	//签到状态，C:迟到，Z：早退，K：旷工，L：请假，N：正常
	private String status;
	
	//描述
	private String describe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(String signInTime) {
		this.signInTime = signInTime;
	}

	public String getSignOutTime() {
		return signOutTime;
	}

	public void setSignOutTime(String signOutTime) {
		this.signOutTime = signOutTime;
	}

	public int getStandardWorkTime() {
		return standardWorkTime;
	}

	public void setStandardWorkTime(int standardWorkTime) {
		this.standardWorkTime = standardWorkTime;
	}

	public double getActualWorkTime() {
		return actualWorkTime;
	}

	public void setActualWorkTime(double actualWorkTime) {
		this.actualWorkTime = actualWorkTime;
	}

	public double getOverTimeLong() {
		return overTimeLong;
	}

	public void setOverTimeLong(double overTimeLong) {
		this.overTimeLong = overTimeLong;
	}

	public double getLateTimeLong() {
		return lateTimeLong;
	}

	public void setLateTimeLong(double lateTimeLong) {
		this.lateTimeLong = lateTimeLong;
	}

	public double getLeaveEarlyTimeLong() {
		return leaveEarlyTimeLong;
	}

	public void setLeaveEarlyTimeLong(double leaveEarlyTimeLong) {
		this.leaveEarlyTimeLong = leaveEarlyTimeLong;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getMonth() {
		return yearMonth;
	}

	public void setMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
}
