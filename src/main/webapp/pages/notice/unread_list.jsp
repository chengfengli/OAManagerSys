<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>未读公告</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">格式</td>
				<td>
					<select id="format" name="format" class="liger-combobox">
						<option value="common" selected="selected">普通</option>
						<option value="MHT">MHT</option>
					</select>
				</td>
				<td class="title">类型</td>
				<td>
					<select id="type" name="type" class="liger-combobox">
						<option value="common" selected="selected">类型一</option>
						<option value="MHT">类型二</option>
						<option value="MHT">类型三</option>
						<option value="MHT">类型四</option>
					</select>
				</td>
				<td class="title"><input type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 已发邮件列表 -->
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/notice/unread_list.js"></script>
</html>