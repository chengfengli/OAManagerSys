<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>联系人</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">姓名:</td>
				<td><input type="text" id="name" /></td>
				<td class="title">组:</td>
				<td>
					<select id="group" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<c:forEach items="${groups }" var="group">
							<option value="${group.id }">${group.groupName }</option>
						</c:forEach>
					</select>
				</td>
				<td class="title"><input type="button" id="select" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 列表 -->
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/communicate/linkmanlist.js"></script>
</html>