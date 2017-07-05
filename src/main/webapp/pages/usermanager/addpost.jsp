<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>编辑角色</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/usermanager/addpost.css" />
		<script>
			//角色已有的权限
			var role={parentMenu:"",childMenu:""};
			//角色ID
			var positionId=0;
			if('${exitsPosition}'!=null && '${exitsPosition}'!=""){
				positionId = '${exitsPosition.id}';
				role.parentMenu = '${exitsPosition.parentMenu}';
				role.childMenu = '${exitsPosition.childMenu}';
			}
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td>编码</td>
				<td>
					<input type="hidden" id="id" value="${exitsPosition.id }" />
					<input type="text" id="positionCode" value="${exitsPosition.positionCode }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>职位</td>
				<td>
					<input type="text" id="positionName" value="${exitsPosition.positionName }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>部门</td>
				<td>
					<select name="department" id="dep" class="liger-combobox">
						<c:if test="${exitsPosition.id != null && exitsPosition.id != '' }">
							<option value="0" selected="selected">---选择部门---</option>
						</c:if>
						<c:forEach items="${deps }" var="dep">
							<c:if test="${dep.id == exitsPosition.dep.id }">
								<option value="${dep.id }" selected="selected">${dep.depName }</option>
							</c:if>
							<c:if test="${dep.id != exitsPosition.dep.id }">
								<option value="${dep.id }">${dep.depName }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="set" value="配置权限" class="liger-button" /></td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/usermanager/addpost.js"></script>
</html>