<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>文件显示</title>
		<%@ include file="/base.jsp" %>
	</head>

	<body style="overflow-x: hidden;">
		<!-- 附件列表 -->
		<input type="hidden" id="fileId" value="${fileId }" />
		<div id="file_list"></div>
	</body>
	<script src="<%=context %>/js/email/file_view.js"></script>
</html>