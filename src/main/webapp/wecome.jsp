<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<% 
	String context = request.getContextPath();
	response.sendRedirect(context+"/index/tologin");
%>