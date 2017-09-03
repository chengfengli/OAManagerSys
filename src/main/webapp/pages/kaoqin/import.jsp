<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>考勤导入</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">月份:</td>
				<td>
					<input type="text" id="month" readonly="readonly" />
				</td>
				<td class="title"><input type="button" id="select" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/kaoqin/import.js"></script>
</html>