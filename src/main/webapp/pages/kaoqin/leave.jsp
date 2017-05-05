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
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/leave.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td>开始时间</td>
				<td>
					<input type="text" name="startTime" id="startTime" />
				</td>
			</tr>
			<tr>
				<td>结束时间</td>
				<td>
					<input type="text" name="endTime" id="endTime" />
				</td>
			</tr>
			<tr>
				<td>请假类型</td>
				<td>
					<select id="leaveType" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="1">事假</option>
						<option value="2">婚假</option>
						<option value="3">产假</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>审批人</td>
				<td>
					<select id="approve" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">请假原因</td>
				<td valign="top">
					<textarea name="reason" id="reason" class="l-textarea"></textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/kaoqin/leave.js"></script>
</html>