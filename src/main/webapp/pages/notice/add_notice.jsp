<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>写信</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/notice/add_notice.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="table">
			<tr>
				<td id="receive">标题</td>
				<td>
					<input type="text" name="title" id="title" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>格式</td>
				<td>
					<select id="format" name="format" class="liger-combobox">
						<option value="common" selected="selected">普通</option>
						<option value="MHT">MHT</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>类型</td>
				<td>
					<select id="type" name="type" class="liger-combobox">
						<option value="common" selected="selected">类型一</option>
						<option value="MHT">类型二</option>
						<option value="MHT">类型三</option>
						<option value="MHT">类型四</option>
					</select>
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
					<input type="file" multiple="true" id="file" name="file" id="enclosure"/>
					<input type="button" id="browse" value="选择..." class="liger-button" /><span id="file_count"></span>
					<ul id="file_list"></ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/notice/add_notice.js"></script>
	<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
</html>