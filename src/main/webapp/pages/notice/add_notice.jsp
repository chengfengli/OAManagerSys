<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>写信</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/notice/add_notice.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="table">
			<tr>
				<td id="receive">标题</td>
				<td>
					<input type="text" id="title" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>格式</td>
				<td>
					<select id="format" class="liger-combobox">
						<option value="common" selected="selected">普通</option>
						<option value="MHT">MHT</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>类型</td>
				<td>
					<select id="type" class="liger-combobox">
						<c:forEach items="${noticeTypes }" var="noticeType">
							<option data-code="${noticeType.typeCode}" value="${noticeType.id}">${noticeType.typeName}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr id="dep_tr" class="none">
				<td>部门</td>
				<td>
					<input type="text" id="dep"/>
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<textarea name="content" id="content" class="l-textarea"></textarea>
				</td>
			</tr>
			<tr>
				<td valign="top">附件</td>
				<td>
					<button id="picker">添加文件</button>
					<input type="file" id="file" multiple style="display:none;" />
					<ul id="file_list">
						
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/notice/add_notice.js"></script>
</html>