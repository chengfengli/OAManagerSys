<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>草稿箱</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body style="overflow-x: hidden;padding-right: 2px;">
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">收件人</td>
				<td><input type="text" id="sender" class="liger-textbox" /></td>
				<td class="title">时间</td>
				<td><input type="text" name="time" id="time" /></td>
				<td class="title"><input id="select" type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 邮件列表 -->
		<div id="email_list"></div>
		
	</body>
	<script src="<%=context %>/js/email/email_draft.js"></script>
</html>