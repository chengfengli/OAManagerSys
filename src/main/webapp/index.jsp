<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>OA管理系统</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/index.css" />
		<script>
			//子菜单
			var childMenu = ${childMenu};
		</script>
	</head>

	<body>
		<!--顶部 S-->
		<div id="topmenu" class="l-topmenu">
			<div class="l-topmenu-logo">OA管理系统</div>
			<div class="l-topmenu-welcome">
				<label> 皮肤切换：</label>
				<select id="skinSelect">
					<option value="aqua">默认</option>
					<option value="silvery">Silvery</option>
					<option value="gray">Gray</option>
					<option value="gray2014">Gray2014</option>
				</select>
				<a href="javascript:void(0)" id="exit">退出</a> 
			</div> 
		</div>
		<!--顶部 E-->
		
		<!--Body S-->
		<div id="layout1" style="width:99.2%; margin:0 auto; margin-top:4px; ">
			<!--左侧菜单-->
			<div position="left"  title="主要菜单" id="menu">
				<c:forEach items="${lists }" var="list">
					<div title="${list.text }" class="l-scroll"><ul id="${list.id }" style="margin-top:3px;"></ul></div>
				</c:forEach>
			</div>
			
			<!--右侧内容-->
			<div position="center" id="framecenter"> 
				<div tabid="home" title="我的主页" style="height:300px" >
					<iframe frameborder="0" name="home" id="home" src=""></iframe>
				</div> 
			</div> 
		</div>
		<!--Body S-->
		
		<!--底部 S-->
		<div  style="height:32px; line-height:32px; text-align:center;">
				Copyright © 2011-2014 www.ligerui.com
		</div>
		<!--底部 E-->
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/index.js"></script>
</html>