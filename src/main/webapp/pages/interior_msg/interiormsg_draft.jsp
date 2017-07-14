<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>内部短信——草稿箱</title>
		<%@ include file="/base.jsp" %>
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 草稿列表 -->
		<div id="list"></div>
	</body>
	<script src="<%=context %>/js/interiormsg/interiormsg_draft.js"></script>
</html>