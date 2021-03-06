<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>手机短信——写短信</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/phone_msg/add.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<table id="email_table">
			<tr>
				<td id="receive">接收人</td>
				<td>
					<input type="text" name="account" id="account" placeholder="输入接收人的手机号" class="liger-textbox" />
				</td>
				<td rowspan="5" valign="top" style="width:150px;">
					<div id="accordion1" class="l-accordion-panel" ligeruiid="accordion1"> 
         				<div class="l-accordion-header l-accordion-header-hasicon">
         					<div class="l-accordion-header-inner">联系人</div>
         				</div>
         				<div class="l-accordion-content">
				        	<ul id="contacts_lsit">
			                	<li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" onclick="add_send_user('列表一')" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" onclick="add_send_user('列表二')" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">17311111111</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li><span class="name">列表一</span><span class="phoneNo">123456</span>
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
				        	</ul>
				        </div>
				    </div>
				</td>
			</tr>
			<tr>
				<td valign="top">内容</td>
				<td valign="top">
					<textarea name="content" id="content" class="l-textarea"></textarea>
				</td>
			</tr>
		</table>
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/phone_msg/add.js"></script>
	<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
</html>