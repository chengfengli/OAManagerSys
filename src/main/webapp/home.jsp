<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% 
	String context = request.getContextPath(); 
	String basePath = request.getServerName() + ":" + request.getServerPort() + context + "/";
	String basePath2 = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ context + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>主页</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="webuploader/webuploader.css">
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script type="text/javascript" src="webuploader/webuploader.js"></script>
		<style type="text/css">
			.progressBarBox{
				border:1px solid #ccc;
				width:300px;
				height:20px;
				margin-bottom:10px;
			}
			.progressBarBox div{
				background:green;
				height:20px;
				float:left;
			}
			.item{
				margin-bottom: 10px;
			}
			.name{
				font-weight: bold;
			}
			.progressBox{
				background: #ccc;
			    overflow: hidden;
			    border-radius: 5px;
			}
			.status{
			    margin-left: 10px;
			    float: left;
			    font-size: 12px;
			    line-height: 20px;
			}
			.progress{
				height: 20px;
    			background: green;
    			width:0;
			}
		</style>
		<script>
			var basePath = '<%=basePath%>';
			var basePath2 = '<%=basePath2%>';
		</script>
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
	
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/home.js"></script>
</html>