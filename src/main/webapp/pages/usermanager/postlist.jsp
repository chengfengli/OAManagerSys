<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>职位管理</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
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