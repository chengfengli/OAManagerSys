<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">类型</td>
				<td>
					<select id="typeCode" class="liger-combobox">
						<option value="all" selected="selected">所有</option>
						<c:forEach items="${list }" var="type">
							<option value="${type.typeCode }">${type.typeName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title">时间:</td>
				<td><input type="text" id="startTime" placeholder="开始时间" /></td>
				<td class="title"><input id="endTime" type="text" placeholder="结束时间" /></td>
				<td class="title"><input id="select" type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 请假等级列表 -->
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/kaoqin/applylist.js"></script>
</html>