<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>申请详情</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/details.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table class="table">
			<tr>
				<td>开始时间</td>
				<td>
					${apply.startTime }
				</td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td>
					${apply.endTime }
				</td>
			</tr>
			<tr>
				<td>申请时长</td>
				<td>
					${apply.longHours }小时
				</td>
			</tr>
			<tr>
				<td>申请类型</td>
				<td>
					${apply.applyType.typeName }
				</td>
			</tr>
			<c:if test="${apply.typeCode=='evection' }">
			<tr>
				<td valign="top">出差地点</td>
				<td valign="top">
					${apply.address }
				</td>
			</tr>
			</c:if>
			<tr>
				<td valign="top">事由</td>
				<td valign="top">
					${apply.reason }
				</td>
			</tr>
			<tr>
				<td>审核人</td>
				<td>
					${apply.approverEmp.name }
				</td>
			</tr>
			<tr>
				<td valign="top">审核时间</td>
				<td valign="top">
					${apply.approvalTimne }
				</td>
			</tr>
			<tr>
				<td valign="top">审核意向</td>
				<td valign="top">
					<c:if test="${apply.status=='a' }">
					<span style='color:green;'>同意</span>
					</c:if>
					<c:if test="${apply.status=='d' }">
					<span style='color:red;'>拒绝</span>
					</c:if>
					<c:if test="${apply.status=='w' }">
					<span style='color:orange;'>待审</span>
					</c:if>
				</td>
			</tr>
			<tr>
				<td valign="top">审核意见</td>
				<td valign="top">
					${apply.opinion }
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/kaoqin/details.js"></script>
</html>