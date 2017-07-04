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
			var view = ${view };
		</script>
	</head>

	<body>
		<div id="toolbar"></div>
		<h2 id="title">基本信息</h2>
		<form id="baseInfor">
			<table id="table">
				<tr style="display:none;">
					<td><input type="hidden"  value="${infor.id }" name="id" /></td>
					<td><input type="hidden"  value="${infor.empNo }" name="empNo" /></td>
				</tr>
				<tr>
					<td>姓名</td>
					<td>
						<input type="text" name="name" value="${emp.name }" class="liger-textbox" />
					</td>
					<td>所属部门</td>
					<td>
						<input type="text" disabled name="depName" value="${emp.dep.depName }" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>性别</td>
					<td>
						<select name="sex" id="sex" class="liger-combobox">
							<c:if test="${infor.sex ==1 }">
								<option value="0">男</option>
								<option value="1" selected="selected">女</option>
							</c:if>
							<c:if test="${infor.sex !=1 }">
								<option value="0" selected="selected">男</option>
								<option value="1">女</option>
							</c:if>
							
						</select>
					</td>
					<td>家庭住址</td>
					<td>
						<input type="text" name="address" value="${infor.address }" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>职位</td>
					<td>
						<input type="text" name="positionName" id="positionName" class="liger-textbox" />
					</td>
					<td>出生日期</td>
					<td>
						<input type="text" name="birthday" value="${infor.birthday }" id="birthday" />
					</td>
				</tr>
				<tr>
					<td>年龄</td>
					<td>
						<input type="text" name="age" value="${infor.age }" class="liger-textbox" />
					</td>
					<td>身份证号</td>
					<td>
						<input type="text" name="idCardNo" value="${infor.idCardNo }" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>学历</td>
					<td>
						<input type="text" name="education" value="${infor.education }" class="liger-textbox" />
					</td>
					<td>毕业院校</td>
					<td>
						<input type="text" name="graduationSchool" value="${infor.graduationSchool }" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>专业</td>
					<td>
						<input type="text" name="major" value="${infor.major }" class="liger-textbox" />
					</td>
					<td>政治面貌</td>
					<td>
						<select name="politics" id="politics" class="liger-combobox">
							<c:if test="${infor.politics == 0 }">
								<option value="0" selected="selected">群众</option>
								<option value="1">党员</option>
								<option value="2">团员</option>
							</c:if>
							<c:if test="${infor.politics == 1 }">
								<option value="0">群众</option>
								<option value="1" selected="selected">党员</option>
								<option value="2">团员</option>
							</c:if>
							<c:if test="${infor.politics == 2 }">
								<option value="0">群众</option>
								<option value="1">党员</option>
								<option value="2" selected="selected">团员</option>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td>身高</td>
					<td>
						<input type="text" name="height" value="${infor.height }" class="liger-textbox" />
					</td>
					<td>婚姻状况</td>
					<td>
						<input type="text" name="maritalStatus" value="${infor.maritalStatus }" placeholder="已婚、未婚、离异、丧偶" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>手机</td>
					<td>
						<input type="text" name="mobilePhone" value="${infor.mobilePhone }" class="liger-textbox" />
					</td>
					<td>电子邮箱</td>
					<td>
						<input type="text" name="email" value="${infor.email }" class="liger-textbox" />
					</td>
				</tr>
				<tr>
					<td>体重</td>
					<td>
						<input type="text" name="weight" value="${infor.weight }" class="liger-textbox" />
					</td>
					<td>有无子女</td>
					<td>
						<select name="children" id="children" class="liger-combobox">
							<c:if test="${infor.children ==0 }">
								<option value="1">有</option>
								<option value="0" selected="selected">无</option>
							</c:if>
							<c:if test="${infor.children !=0 }">
								<option value="1" selected="selected">有</option>
								<option value="0">无</option>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td valign="top">签名</td>
					<td>
						<textarea name="autograph">${infor.autograph }</textarea>
					</td>
					<td valign="top">个人说明</td>
					<td>
						<textarea name="explain">${infor.explain }</textarea>
					</td>
				</tr>
				<tr>
					<td valign="top">禁忌</td>
					<td>
						<textarea name="taboo">${infor.taboo }</textarea>
					</td>
					<td valign="top">兴趣爱好</td>
					<td>
						<textarea name="hobby">${infor.hobby }</textarea>
					</td>
				</tr>
			</table>
		</form>
	</body>
	<script src="<%=context %>/js/manageset/editinfomation.js"></script>
</html>