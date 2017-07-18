<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>请假登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/communicate/addlinkman.css" />
		<script>
			var groupId = '${linkMan.groupId }'
		</script>
	</head>

	<body>
		<table id="table">
			<tr>
				<td>姓名</td>
				<td>
					<input type="hidden" id="id" value="${linkMan.id }" />
					<input type="text" id="name" value="${linkMan.name }" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>分组</td>
				<td>
					<select id="group" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<c:forEach items="${groups }" var="group">
							<option value="${group.id }">${group.groupName }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">住址</td>
				<td valign="top">
					<textarea id="address" value="${linkMan.address }" class="l-textarea"></textarea>
				</td>
			</tr>
			<tr>
				<td>手机</td>
				<td>
					<input type="text"   id="mobile" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>电话</td>
				<td>
					<input type="text" value="${linkMan.telephone }" id="telephone" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>QQ</td>
				<td>
					<input type="text" value="${linkMan.qq }" id="qq" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>邮箱</td>
				<td>
					<input type="text" value="${linkMan.email }" id="email" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>其他</td>
				<td>
					<input type="text" value="${linkMan.other }" id="other" class="liger-textbox" />
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/communicate/addlinkman.js"></script>
</html>