<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>邮件详情-发送</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_details.css" />
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table class="email_table">
			<tr>
				<td>接收人</td>
				<td>
					${email.acceptName }
				</td>
			</tr>
			<tr>
				<td>号码</td>
				<td>
					${email.acceptNo }
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
						<c:forEach items="${email.list }" var="file">
							<li>${file.fileName }&nbsp;&nbsp;${file.fileSize }&nbsp;&nbsp;<a href="javascript:void(0)">预览</a>&nbsp;<a class="download" href="javascript:void(0)" data-id="${file.id }">下载</a></li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/email/email_details.js"></script>
</html>