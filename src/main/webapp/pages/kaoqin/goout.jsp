<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>外出登记</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/kaoqin/goout.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<table id="email_table">
			<tr>
				<td>外出时间</td>
				<td>
					<input type="text" name="goouttime" id="goouttime" />
				</td>
			</tr>
			<tr>
				<td>审批人</td>
				<td>
					<select id="approve" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="1991">1991</option>
						<option value="1992">1992</option>
						<option value="1993">1993</option>
						<option value="1994">1994</option>
					</select>
				</td>
			</tr>
			<tr>
				<td valign="top">外出原因</td>
				<td valign="top">
					<textarea name="reason" id="reason" class="l-textarea"></textarea>
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
			<tr>
				<td colspan="2" style="text-align:center;">
					<input type="button" id="submit" value="申请外出" class="liger-button" />
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/kaoqin/goout.js"></script>
</html>