<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>写信</title>
		<%@ include file="/base.jsp" %>
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_add.css" />
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="email_table">
			<tr>
				<td id="receive">收件人</td>
				<td>
					<input type="text" id="account" class="liger-textbox" />
				</td>
				<td rowspan="5" valign="top" style="width:150px;">
					<div id="accordion1" class="l-accordion-panel" ligeruiid="accordion1"> 
         				<div class="l-accordion-header l-accordion-header-hasicon">
         					<div class="l-accordion-header-inner">联系人</div>
         				</div>
         				<div class="l-accordion-content">
				        	<ul id="contacts_lsit">
				        		<c:forEach items="${emps }" var="emp">
				                	<li>${emp.name }<img src="<%=context %>/icon/group_send.png" onclick="add_group_send('${emp.id }')" title="抄送人" />
				                		<img src="<%=context %>/icon/send_user.png" onclick="add_send_user('${emp.id }')" class="send_user" title="收件人" />
				                		<span class="depName">${emp.dep.depName }</span>
				                	</li>
				        		</c:forEach>
				        	</ul>
				        </div>
				    </div>
				</td>
			</tr>
			<tr>
				<td>抄送</td>
				<td>
					<input type="text" id="chaosong" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>主题</td>
				<td>
					<input type="text" id="title" class="liger-textbox" />
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
					<div id="picker">文件上传</div>
					<input type="file" multiple="true" id="file" name="file" id="enclosure"/>
					<ul id="file_list"></ul>
				</td>
			</tr>
		</table>
	</body>
	
	<script src="<%=context %>/js/email/email_add.js"></script>
</html>