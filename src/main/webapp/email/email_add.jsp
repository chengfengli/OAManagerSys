<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>写信</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_add.css" />
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="email_table">
			<tr>
				<td id="receive">收件人</td>
				<td>
					<input type="text" name="account" id="account" class="liger-textbox" />
				</td>
				<td rowspan="5" valign="top" style="width:150px;">
					<div id="accordion1" class="l-accordion-panel" ligeruiid="accordion1"> 
         				<div class="l-accordion-header l-accordion-header-hasicon">
         					<div class="l-accordion-header-inner">联系人</div>
         				</div>
         				<div class="l-accordion-content">
				        	<ul id="contacts_lsit">
			                	<li>列表一</li>
			                    <li>列表二</li>
			                    <li>列表三</li>
			                    <li>列表四</li>
			                    <li>列表五</li>
			                    <li>列表一</li>
			                    <li>列表二</li>
			                    <li>列表三</li>
			                    <li>列表四</li>
			                    <li>列表五</li>
				        	</ul>
				        </div>
				    </div>
				</td>
			</tr>
			<tr>
				<td>抄送</td>
				<td>
					<input type="text" name="chaosong" id="chaosong" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>主题</td>
				<td>
					<input type="text" name="subject" id="subject" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>内容</td>
				<td>
					<input type="text" name="content" id="content" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>附件</td>
				<td>
					<input type="text" name="enclosure" id="enclosure" class="liger-textbox" />
				</td>
			</tr>
		</table>
		
		<input type="button" id="loginBtn" value="登录" class="liger-button" />
		
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/email/email_add.js"></script>
</html>