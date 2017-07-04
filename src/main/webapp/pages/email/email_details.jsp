<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>邮件详情</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_details.css" />
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
			</tr>
			<tr>
				<td>抄送</td>
				<td>
					<input type="text" disable name="chaosong" id="chaosong" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td>主题</td>
				<td>
					<input type="text" name="subject" id="subject" class="liger-textbox" />
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<div id="content">asdfsdaaf打发士大夫撒打发士大夫啊手动阀啊打发啊打发啊打发微软的发放</div>
				</td>
			</tr>
			<tr>
				<td valign="top">附件</td>
				<td>
					<ul>
						<li>sdfasdfsadf.jpg</li>
						<li>sdfasdfsadf.jpg</li>
						<li>sdfasdfsadf.jpg</li>	
					</ul>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/email/email_details.js"></script>
</html>