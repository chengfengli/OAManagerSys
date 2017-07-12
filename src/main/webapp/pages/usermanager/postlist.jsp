<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>职位管理</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<table id="querybar">
			<tr>
				<td class="title">职位</td>
				<td><input type="text" id="post" class="liger-textbox" /></td>
				<td class="title">部门</td>
				<td>
					<select id="department" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<c:forEach items="${deps }" var="dep">
						<option value="${dep.id }">${dep.depName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title"><input id="select" type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 列表 -->
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/usermanager/postlist.js"></script>
</html>