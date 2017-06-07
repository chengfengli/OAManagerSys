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
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/email/email_add.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/wangEditor/dist/css/wangEditor.min.css">
		<link rel="stylesheet" type="text/css" href="<%=context %>/webuploader/webuploader.css">
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script src="<%=context %>/webuploader/webuploader.js"></script>
		<script src="<%=context %>/wangEditor/dist/js/wangEditor.js"></script>
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
			                	<li>列表一<img src="<%=context %>/icon/group_send.png" onclick="add_group_send('列表一')" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" onclick="add_send_user('列表一')" class="send_user" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表二<img src="<%=context %>/icon/group_send.png" onclick="add_group_send('列表二')" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" onclick="add_send_user('列表二')" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表三<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表一<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表二<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表三<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表一<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表二<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表三<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表一<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表二<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表三<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                	<li>列表四<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
			                    <li>列表五<img src="<%=context %>/icon/group_send.png" title="抄送人" alt="send_user" />
			                		<img src="<%=context %>/icon/send_user.png" title="收件人" alt="send_user" />
			                	</li>
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
					<div id="picker">文件上传</div><span id="file_count"></span>
					<ul id="file_list"></ul>
					<input type="button" value="上传" id="uploadBtn" />
				</td>
			</tr>
		</table>
	</body>
	
	<script src="<%=context %>/js/email/email_add.js"></script>
	<%-- <script src="<%=context %>/js/upload.js"></script> --%>
	<script>
		var uploader = WebUploader.create({
			//chunked: true,
		    // swf文件路径
		    swf:'<%=context %>/webuploader/Uploader.swf',
		    // 文件接收服务端。
		    server: 'file/upload',
		    // 选择文件的按钮。可选。内部根据当前运行是创建，可能是input元素，也可能是flash.
		    pick: '#picker',
		    // 不压缩image, 默认如果是jpeg，文件上传前会压缩一把再上传！
		    resize: false,
		    auto:false
		});
		
	

	</script>
</html>