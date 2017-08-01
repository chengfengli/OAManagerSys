<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/leave.css" />
	</head>

	<body style="overflow: hidden;">
		<table id="table">
			<tr>
				<td>开始时间</td>
				<td>
					<input type="text" id="startTime" />
				</td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td>
					<input type="text" id="endTime" />
				</td>
			</tr>
			<tr>
				<td>请假时长</td>
				<td>
					<span id="longHours">0</span>小时
				</td>
			</tr>
			<tr>
				<td>请假类型</td>
				<td>
					<select class="typeCode" id="typeCode" class="liger-combobox">
						<option value=" " selected="selected">请选择</option>
						<c:forEach items="${types }" var="type">
							<option value="${type.typeCode }">${type.typeName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>审批人</td>
				<td>
					<select id="approver" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="10001">1991</option>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">请假原因</td>
				<td valign="top">
					<textarea name="reason" id="reason" class="l-textarea"></textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/kaoqin/goout.js"></script>
</html>