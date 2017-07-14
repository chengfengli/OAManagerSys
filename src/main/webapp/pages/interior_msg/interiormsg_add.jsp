<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>内部短信——写短信</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/interiormsg/interiormsg_add.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="email_table">
			<tr>
				<td id="receive">接收人</td>
				<td>
					<input type="hidden" id="id" value="${msg.id }" />
					<input type="text" name="account" id="account" value="${msg.acceptNo }" placeholder="输入接收人的内部短号" class="liger-textbox" />
				</td>
				<td rowspan="5" valign="top" style="width:150px;">
					<div id="accordion1" class="l-accordion-panel" ligeruiid="accordion1"> 
         				<div class="l-accordion-header l-accordion-header-hasicon">
         					<div class="l-accordion-header-inner">联系人</div>
         				</div>
         				<div class="l-accordion-content">
				        	<ul id="contacts_lsit">
				        		<c:forEach items="${emps }" var="emp">
				                	<li>
				                		<span class="name">${emp.name }</span><span class="shortNo">${emp.id }</span>
				                		<img src="<%=context %>/Source/lib/ligerUI/skins/icons/add.gif" onclick="add_send_user(${emp.id })" title="收件人" />
				                	</li>
				        		</c:forEach>
				        	</ul>
				        </div>
				    </div>
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<textarea id="content" class="l-textarea">${msg.content }</textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/interiormsg/interiormsg_add.js"></script>
</html>