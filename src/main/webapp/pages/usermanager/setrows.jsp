<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/setrows.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
			var childMenu = ${childMenu};
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td valign="top">
					<c:forEach items="${lists }" var="list">
						<input type="checkbox" id="${list.id }" data-text="${list.text }" class="liger-checkbox" />${list.text }<br>
					</c:forEach>
				</td>
				<td>
					<input id="key" type="hidden" value="" /><input id="text" type="hidden" value="" />
					<textarea></textarea>
				</td>
			</tr>
		</table>
		<input type="button" id="add" value="添加" class="liger-button" />
		<div id="error"></div>
	</body>
	<script src="<%=context %>/js/usermanager/setrows.js"></script>
</html>