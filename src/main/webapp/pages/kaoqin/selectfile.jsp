<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>选择文件</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/selectfile.css" />
	</head>

	<body>
		<input type="button" id="select" value="选择文件" class="liger-button" />
		<input type="file" id="file" multiple style="display:none;" />
		<div id="file_list"></div>
	</body>
	<script src="<%=context %>/js/kaoqin/selectfile.js"></script>
</html>