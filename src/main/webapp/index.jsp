<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>OA</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/index.css" />
		<script>
			//子菜单
			var childMenu = ${childMenu};
		</script>
	</head>

	<body>
		<!--顶部 S-->
		<div id="topmenu" class="l-topmenu">
			<div class="l-topmenu-logo">OA管理系统<span id="dateTime"></span></div>
			<div id="marquee">
				<marquee id="marqueetxt" width="100%" height="26">指整个Marquee对齐方式</marquee>
			</div>
			<div class="l-topmenu-welcome">
				<label>角色</label>
				<select id="role">
					<c:forEach items="${positions }" var="position">
						<c:if test="${position.positionCode == currentPosition }">
							<option value="${position.positionCode }" selected="selected">${position.positionName }</option>
						</c:if>
						<c:if test="${position.positionCode != currentPosition }">
							<option value="${position.positionCode }">${position.positionName }</option>
						</c:if>
					</c:forEach>
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
					<iframe frameborder="0" name="home" id="home" src="<%=context %>/home.jsp"></iframe>
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
	<script src="<%=context %>/js/index.js"></script>
</html>