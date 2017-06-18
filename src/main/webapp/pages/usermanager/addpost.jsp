<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/addpost.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td>编码</td>
				<td>
					<input type="text" id="positionCode" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>职位</td>
				<td>
					<input type="text" id="positionName" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>部门</td>
				<td>
					<select name="department" id="dep" class="liger-combobox">
						<option value=" " selected="selected">---选择部门---</option>
						<c:forEach items="${deps }" var="dep">
							<option value="${dep.id }">${dep.depName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="set" value="配置权限" class="liger-button" /></td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/usermanager/addpost.js"></script>
</html>