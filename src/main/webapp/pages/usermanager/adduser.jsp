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
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/adduser.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="table">
			<tr>
				<td>姓名</td>
				<td>
					<input type="hidden" id="id" value="${emp.id }"/>
					<input type="text" value="${emp.name }" id="name" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>入职时间</td>
				<td>
					<input type="text" value="${emp.entryTime }" id="entryTime" />
				</td>
			</tr>
			<tr>
				<td>部门</td>
				<td>
					<select name="department" id="department" class="liger-combobox">
						<c:if test="${emp == null || emp == '' }">
							<option value="0" selected="selected">---请选择---</option>
							<c:forEach items="${deps }" var="dep">
								<option value="${dep.id }">${dep.depName }</option>
							</c:forEach>
						</c:if>
						<c:if test="${emp != null && emp != '' }">
							<option value="0">---请选择---</option>
							<c:forEach items="${deps }" var="dep">
								<c:if test="${dep.id == emp.depId }">
									<option value="${dep.id }" selected="selected">${dep.depName }</option>
								</c:if>
								<c:if test="${dep.id != emp.depId }">
									<option value="${dep.id }">${dep.depName }</option>
								</c:if>
							</c:forEach>
						</c:if>
					</select>
				</td>
			</tr>
			<tr>
				<td>职位</td>
				<td>
					<input type="hidden" value="${emp.positionId }" id="positionId" />
					<input type="text" id="position" />
				</td>
			</tr>
			<tr>
				<td>试用时间</td>
				<td>
					<select id="probationPeriod" class="liger-combobox">
						<c:forEach begin="1" end="5" varStatus="status">
							<c:if test="${emp.probationPeriod == status.index}">
								<option value="${status.index }" selected="selected">${status.index }个月</option>
							</c:if>
							<c:if test="${emp.probationPeriod != status.index}">
								<option value="${status.index }">${status.index }个月</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/usermanager/adduser.js"></script>
</html>