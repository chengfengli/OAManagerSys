<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>登录失效</title>
		<%@ include file="/base.jsp" %>
		<script>
			$(function(){
				parent.location.href = path+"/index/tologin";
				/* $.ligerDialog.confirm('登陆已失效，请重新登陆', function (yes) {
					if(yes){
					}
				}); */
			});
		</script>
	</head>
</html>
