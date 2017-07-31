<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>公告通知详情</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/notice/details.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table class="email_table">
			<tr>
				<td>标题</td>
				<td>
					${notice.title }
				</td>
			</tr>
			<tr>
				<td>格式</td>
				<td>
					<c:if test="${notice.format=='common' }">
						普通
					</c:if>
					<c:if test="${notice.format=='MHT' }">
						MHT
					</c:if>
				</td>
			</tr>
			<tr>
				<td>类型</td>
				<td>
					${notice.type.typeName }
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<div id="content">${notice.content }</div>
				</td>
			</tr>
			<tr>
				<td valign="top">附件</td>
				<td>
					<ul>
						<c:forEach items="${notice.list }" var="file">
							<li>${file.fileName }&nbsp;&nbsp;${file.fileSize }&nbsp;&nbsp;<a href="javascript:void(0)">预览</a>&nbsp;<a class="download" href="javascript:void(0)" data-id="${file.id }">下载</a></li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/notice/details.js"></script>
</html>