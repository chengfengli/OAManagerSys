<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String context = request.getContextPath(); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta http-equiv="content-type" content="text/html;charset=utf-8">
		<title>账号安全</title>
		<link rel="stylesheet" type="text/css" href="<%=context %>/Source/lib/ligerUI/skins/Aqua/css/ligerui-all.css" />
		<link rel="stylesheet" type="text/css" href="<%=context %>/css/manageset/setpwd.css" />
	</head>

	<body>
		<table id="table1" cellspacing="1" cellpadding="0">
			<tbody>
				<tr>
					<td>当前密码安全状态：</td>
					<td>
						<ul class="curentTrength">
							<li class="defaultbg enough"></li>
							<li class="defaultbg medium"></li>
							<li class="defaultbg"></li>
						</ul>
					</td>
				</tr>
				<tr>
					<td valign="top">修改密码：</td>
					<td>
						<form id="updateForm">
							<table id="tabelpwd">
								<tr>
									<td>原密码：</td>
									<td><input type="text" name="oilPwd" id="oilPwd" width="180" class="liger-textbox" /></td>
								</tr>
								<tr>
									<td valign="top">新密码：</td>
									<td><input type="text" name="newPwd" id="newPwd" width="180" class="liger-textbox" />
										<ul class="curentTrength">
											<li id="enough" class="defaultbg"></li>
											<li id="medium" class="defaultbg"></li>
											<li id="strong" class="defaultbg"></li>
										</ul>
									</td>
								</tr>
								<tr>
									<td>再次确认：</td>
									<td><input type="text" name="reNewPwd" id="reNewPwd" width="180" class="liger-textbox" /></td>
								</tr>
							</table>
							<input type="button" id="update" value="修改" class="liger-button" />
						</form>
					</td>
				</tr>
			</tbody>
		</table>
	</body>
	<script src="<%=context %>/js/jquery-1.9.0.min.js"></script>
	<script src="<%=context %>/Source/lib/ligerUI/js/ligerui.all.js"></script>
	<script src="<%=context %>/js/manageset/setpwd.js"></script>
</html>