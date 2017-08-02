<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>添加申请</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/apply.css" />
	</head>

	<body>
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
				<td>外出时长</td>
				<td>
					<span id="longHours">0</span>小时
				</td>
			</tr>
			<tr>
				<td>申请类型</td>
				<td>
					<select id="typeCode" class="liger-combobox">
						<option value=" " selected="selected">请选择</option>
						<c:forEach items="${list }" var="type">
							<option value="${type.typeCode }">${type.typeName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>出差地点</td>
				<td>
					<input type="text" id="address"  class="liger-textbox" />
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
				<td valign="top">外出原因</td>
				<td valign="top">
					<textarea id="reason" class="l-textarea"></textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/kaoqin/apply.js"></script>
</html>