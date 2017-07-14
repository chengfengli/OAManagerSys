<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>内部短信——收信箱</title>
		<%@ include file="/base.jsp" %>
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 已接收短信列表 -->
		<div id="list"></div>
		
	</body>
	<script src="<%=context %>/js/interiormsg/interiormsg_inbox.js"></script>
</html>