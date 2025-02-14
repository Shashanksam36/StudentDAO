<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%><!-- @page import to import java packages -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
	<%@include file="Header.jsp"%><!-- @include is used to import page from a different jsp file -->
	<h1 style="color:gray; background-color:aqua; font-family:cursive;">Date and Time</h1>
	<% Date d=new Date(); %> <!-- scriptlet tag  used to write java code-->
	<%=d %> <!-- expression tag to print the variables-->
</body>
</html>