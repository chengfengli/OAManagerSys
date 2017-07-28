<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>编辑公告类型</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/notice/addNoticeType.css" />
	</head>

	<body>
		<table id="table">
			<tr>
				<td>类型编码</td>
				<td>
					<input type="hidden" id="id" value="${noticeType.id }" />
					<input type="text" name="depCode" id="typeCode" value="${noticeType.typeCode }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>类型名称</td>
				<td>
					<input type="text" name="depName" id="typeName" value="${noticeType.typeName }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td valign="top">描述</td>
				<td>
					<textarea id="describe">${noticeType.describe }</textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/notice/addNoticeType.js"></script>
</html>