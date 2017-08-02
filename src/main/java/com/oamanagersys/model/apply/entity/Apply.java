package com.oamanagersys.model.apply.entity;

import com.oamanagersys.model.user.entity.Emp;
import com.oamanagersys.util.base.BaseEntity;
import com.oamanagersys.util.format.DateFormat;

/**
 * 申请实体类
 * @author	李明
 * @tel		17310545652
 * @createtime	2017年8月1日 下午2:42:55
 */
public class Apply extends BaseEntity{
	//类型code
	private String typeCode;
	
	//类型
	private ApplyType applyType;
	
	//开始时间
	private String startTime;
	
	//结束时间
	private String endTime;
	
	//时长
	private int longHours;
	
	//事由
	private String reason;
	
	//地址
	private String address;
	
	//审批人
	private int approver;
	
	private Emp approverEmp;
	
	//审批时间
	private String approvalTimne;
	
	//审核状态 w：待审，a：同意，d：拒绝
	private String status;
	
	//审核意见
	private String opinion;

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public ApplyType getApplyType() {
		return applyType;
	}

	public void setApplyType(ApplyType applyType) {
		this.applyType = applyType;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		startTime = DateFormat.format(startTime, "yyyy-MM-dd HH:mm");
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		endTime = DateFormat.format(endTime, "yyyy-MM-dd HH:mm");
		this.endTime = endTime;
	}

	public int getLongHours() {
		return longHours;
	}

	public void setLongHours(int longHours) {
		this.longHours = longHours;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getApprover() {
		return approver;
	}

	public void setApprover(int approver) {
		this.approver = approver;
	}

	public String getApprovalTimne() {
		return approvalTimne;
	}

	public void setApprovalTimne(String approvalTimne) {
		this.approvalTimne = approvalTimne;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Emp getApproverEmp() {
		return approverEmp;
	}

	public void setApproverEmp(Emp approverEmp) {
		this.approverEmp = approverEmp;
	}
}
