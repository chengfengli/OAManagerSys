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
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/communicate/addlinkman.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td>姓名</td>
				<td>
					<input type="text" name="name" id="name" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>分组</td>
				<td>
					<select id="group" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="1">分组一</option>
						<option value="2">分组二</option>
						<option value="3">分组三</option>
						<option value="4">分组四</option>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">住址</td>
				<td valign="top">
					<textarea name="address" id="address" class="l-textarea"></textarea>
				</td>
			</tr>
			<tr>
				<td>手机</td>
				<td>
					<input type="text" name="mobile" id="mobile" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>
					<input type="text" name="telephone" id="telephone" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>QQ</td>
				<td>
					<input type="text" name="qq" id="qq" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input type="text" name="email" id="email" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>其他</td>
				<td>
					<input type="text" name="other" id="other" class="liger-textbox" />
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/communicate/addlinkman.js"></script>
</html>