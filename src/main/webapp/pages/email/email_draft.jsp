<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>草稿箱</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
		<script>
			var path = '<%=context %>';
		</script>
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
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/email/email_draft.js"></script>
</html>