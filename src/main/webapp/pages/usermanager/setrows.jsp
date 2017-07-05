<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/setrows.css" />
		<script>
			//所有主菜单
			var parentMenu = ${lists};
			//所有子菜单
			var childMenu = ${childMenu};
			//职位已有的主菜单
			var existParentMenu = [];
			//职位已有的子菜单
			var existChildMenu = {};
			if('${exitsPosition}' != ''){
				existParentMenu = JSON.parse('${exitsPosition.parentMenu}');
				existChildMenu = JSON.parse('${exitsPosition.childMenu}');
			}
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td valign="top" id="menu">
				</td>
				<td valign="top">
					<input id="key" type="hidden" value="" /><input id="text" type="hidden" value="" />
					<ul id="childMenuTree">
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/usermanager/setrows.js"></script>
</html>