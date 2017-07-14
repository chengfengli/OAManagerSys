<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>邮件详情</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_details.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table class="email_table">
			<tr>
				<td>发送人</td>
				<td>
					${msg.emp.name }
				</td>
			</tr>
			<tr>
				<td>号码</td>
				<td>
					${msg.sendNo }
				</td>
			</tr>
			<tr>
				<td>发送时间</td>
				<td>
					${msg.sendTime }
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<div id="content">${msg.content }</div>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/email/email_details.js"></script>
</html>