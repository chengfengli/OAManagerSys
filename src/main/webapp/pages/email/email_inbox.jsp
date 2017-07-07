<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>收件箱</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">发件人</td>
				<td><input type="text" id="sendName" class="liger-textbox" /></td>
				<td class="title">状态</td>
				<td>
					<select id="status" class="liger-combobox">
						<option value="-1" selected="selected">请选择</option>
						<option value="1">已读</option>
						<option value="0">未读</option>
					</select>
				</td>
				<td class="title">时间</td>
				<td><input type="text" id="sendTime" readonly="readonly" /></td>
				<td class="title"><input id="select" type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 邮件列表 -->
		<div id="email_list"></div>
	</body>
	<script src="<%=context %>/js/email/email_inbox.js"></script>
</html>