<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>添加联系组</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/communicate/addgroup.css" />
	</head>

	<body>
		<table id="table">
			<tr>
				<td>编码</td>
				<td>
					<input type="hidden" id="id" value="" />
					<input type="text" id="groupCode"  class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>组名</td>
				<td>
					<input type="text" id="groupName"  class="liger-textbox" />
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/communicate/addgroup.js"></script>
</html>