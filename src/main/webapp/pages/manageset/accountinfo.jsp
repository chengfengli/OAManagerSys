<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>账号安全</title>
		<style type="text/css">
			table{
				width: 90%;border-color:#E5EFFE; border-collapse: collapse;
				margin:50px auto;
			}
			table th{
				font-weight:bold;
			}
			table th,table td{
				text-align:center;
				padding:5px;
				font-size:12px;
			}
		</style>
	</head>

	<body>
		
		<table border="1" cellspacing="1" cellpadding="0">
			<thead>
				<tr>
					<th>登录别名</th>
					<th>职位信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>乘风李</td>
					<td>超级管理员</td>
				</tr>
			</tbody>
		</table>
	</body>
</html>