<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>主页</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/webuploader/webuploader.css">
		<script type="text/javascript" src="<%=context %>/webuploader/webuploader.js"></script>
		
	</head>

	<body>
		<div id="uploader" class="wu-example">
		    <!--用来存放文件信息-->
		    <div id="thelist" class="uploader-list">
		    	
		    </div>
		    <div class="btns">
		        <div id="picker">选择文件</div>
		        <button id="ctlBtn" onclick="start()" class="btn btn-default">开始上传</button>
		        <button id="ctlBtn" onclick="stop()" class="btn btn-default">暂停</button>
		        <button id="ctlBtn" onclick="cancel()" class="btn btn-default">取消</button>
		    </div>
		</div>
		<input type="text" id="txt" />
		<input type="button" id="send" value="发送" />
	</body>
	
	<script src="<%=context %>/js/upload.js"></script>
</html>