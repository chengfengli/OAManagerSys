<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>考勤登记</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/commons/commons.css" />
	</head>

	<body>
		<!-- 工具栏 -->
		<div id="toolbar"></div>
		<!-- 搜索栏 -->
		<table id="querybar">
			<tr>
				<td class="title">月份:</td>
				<td>
					<select id="month" name="month" class="liger-combobox">
						<option value="0" selected="selected">请选择</option>
						<option value="1">一月</option>
						<option value="2">二月</option>
						<option value="3">三月</option>
						<option value="4">四月</option>
						<option value="5">五月</option>
						<option value="6">六月</option>
						<option value="7">七月</option>
						<option value="8">八月</option>
						<option value="9">九月</option>
						<option value="10">十月</option>
						<option value="11">十一月</option>
						<option value="12">十二月</option>
					</select>
				</td>
				<td class="title"><input type="button" value="查询" class="liger-button" /></td>
			</tr>
		</table>
		<!-- 考勤列表 -->
		<div id="list"></div>
		
	</body>
	<script src="<%=context %>/js/kaoqin/kaoqin.js"></script>
</html>