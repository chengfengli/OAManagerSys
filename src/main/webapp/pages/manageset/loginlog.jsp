<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>工作日报</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<style type="text/css">
			table{
				width:100%;
				border-collapse:collapse;border:none;
			}
			table thead{
				background: url(<%=context %>/icon/header-bg.gif);
			}
			
			table th,table td{
				border:1px solid #BED5F3;
				padding:7px 0;
				text-align:center;
				font-size:12px;
			}
		</style>
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<!-- 列表 -->
		<table>
			<thead>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
				<tr>
					<td>登录时间</td>
					<td>登录IP</td>
					<td>地点</td>
				</tr>
			</tbody>
		</table>
	</body>
	<script src="<%=context %>/js/manageset/loginlog.js"></script>
</html>