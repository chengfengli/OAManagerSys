<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>邮件详情</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_details.css" />
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="email_table">
			<tr>
				<td id="receive">发件人名称</td>
				<td>
					${email.emp.name }
				</td>
			</tr>
			<tr>
				<td id="receive">发件人号码</td>
				<td>
					${email.sendNo }
				</td>
			</tr>
			<tr>
				<td>抄送</td>
				<td>
					${email.copyer }
				</td>
			</tr>
			<tr>
				<td>主题</td>
				<td>
					${email.title }
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<div id="content">${email.content }</div>
				</td>
			</tr>
			<tr>
				<td valign="top">附件</td>
				<td>
					<ul>
						<li>sdfasdfsadf.jpg&nbsp;&nbsp;<a href="javascript:void(0)">预览</a>&nbsp;<a href="javascript:void(0)">下载</a></li>
						<li>sdfasdfsadf.jpg&nbsp;&nbsp;<a href="javascript:void(0)">预览</a>&nbsp;<a href="javascript:void(0)">下载</a></li>
						<li>sdfasdfsadf.jpg&nbsp;&nbsp;<a href="javascript:void(0)">预览</a>&nbsp;<a href="javascript:void(0)">下载</a></li>	
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/email/email_details.js"></script>
</html>