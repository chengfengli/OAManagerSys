<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/adddepartment.css" />
	</head>

	<body>
		<table id="table">
			<tr>
				<td>编码</td>
				<td>
					<input type="hidden" id="id" value="${dep.id }" />
					<input type="text" name="depCode" id="depCode" value="${dep.depCode }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>名称</td>
				<td>
					<input type="text" name="depName" id="depName" value="${dep.depName }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td valign="top">描述</td>
				<td>
					<textarea id="describe">${dep.describe }</textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/usermanager/adddepartment.js"></script>
</html>