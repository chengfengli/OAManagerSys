<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>内部短信——发信箱</title>
		<%@ include file="/base.jsp" %>
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 已发邮件列表 -->
		<div id="msg_list"></div>
	</body>
	<script src="<%=context %>/js/interiormsg/interiormsg_sended.js"></script>
</html>