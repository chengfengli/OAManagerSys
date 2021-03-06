<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<% String context = request.getContextPath(); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" href="<%=context %>/css/login/login.css" />
		<!-- <link rel="icon" href="img/yun.png" type="image/x-icon"/> -->
	</head>
	<body>
		<canvas id="canvas"></canvas>	
		<fieldset id="login_box">
			<legend>用&nbsp;户&nbsp;登&nbsp;录</legend>
			<form id="login_form">
				<table id="login_table">
					<tr>
						<td>账号</td>
						<td>
							<input type="text" id="id" name="id" value="10001"  autocomplete="off"/>
							<div id="downmenu_ico"></div>
							<ul id="account-list"></ul>
						</td>
					</tr>
					<tr>
						<td>密码</td>
						<td>
							<input type="text" id="password" name="password" value="123456" autocomplete="off" onfocus="this.type='password'"/>
						</td>
					</tr>
					<tr>
						<td>验证码</td>
						<td>
							<input type="code" id="code" name="code" placeholder="点击验证码切换"/>
							<input type="button" id="code_content" style="background:url('<%=context %>/user/code');" />
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="checkbox" id="remember" name="remember" />
							<label for="remember">记住密码</label>
							<input type="button" id="loginbtn" />
						</td>
					</tr>
				</table>
			</form>
		</fieldset>
	</body>
	<script src="<%=context %>/Source/lib/jquery/jquery-1.9.0.min.js" ></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/canvas.js" ></script>
	<script src="<%=context %>/js/login/login.js" ></script>
	<script>
		var path = "<%=context %>";
	</script>
</html>
