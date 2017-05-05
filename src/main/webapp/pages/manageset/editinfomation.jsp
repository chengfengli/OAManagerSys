<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>编辑个人信息</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/ligerui-icons.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/manageset/editinfomation.css" />
		<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
		<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
		<script>
			var path = '<%=context %>';
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<h2 id="title">基本信息</h2>
		<form>
			<table id="table">
				<tr>
					<td>姓名</td>
					<td>
						<input type="text" name="name" id="name" class="liger-textbox" />
					</td>
					<td>性别</td>
					<td>
						<select name="sex" id="sex" class="liger-combobox">
							<option value="0" selected="selected">男</option>
							<option value="1">女</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>家庭住址</td>
					<td>
						<input type="text" name="address" id="address" class="liger-textbox" />
					</td>
					<td>出生日期</td>
					<td>
						<input type="text" name="birthDay" id="birthDay" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>身份证号</td>
					<td>
						<input type="text" name="idCard" id="idCard" class="liger-textbox" />
					</td>
					<td>年龄</td>
					<td>
						<input type="text" name="age" id="age" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>毕业院校</td>
					<td>
						<input type="text" name="school" id="school" class="liger-textbox" />
					</td>
					<td>学历</td>
					<td>
						<input type="text" name="education" id="education" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<input type="text" name="major" id="major" class="liger-textbox" />
					</td>
					<td>政治面貌</td>
					<td>
						<select name="politicsStatus" id="politicsStatus" class="liger-combobox">
							<option value="0" selected="selected">群众</option>
							<option value="1">党员</option>
							<option value="2">团员</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>身高</td>
					<td>
						<input type="text" name="height" id="height" class="liger-textbox" />
					</td>
					<td>体重</td>
					<td>
						<input type="text" name="weight" id="weight" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>手机</td>
					<td>
						<input type="text" name="mobile" id="mobile" class="liger-textbox" />
					</td>
					<td>邮箱</td>
					<td>
						<input type="text" name="email" id="email" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td valign="top">个性签名</td>
					<td>
						<textarea name="signature" id="signature"></textarea>
					</td>
					<td valign="top">个人说明</td>
					<td>
						<textarea name="state" id="state"></textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script src="<%=context %>/js/manageset/editinfomation.js"></script>
</html>