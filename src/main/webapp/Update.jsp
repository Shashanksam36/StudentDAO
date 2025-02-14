<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.student.dto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style>
	*{
	text-decoration:none;
	color:white;
	background-color:black;
	}
	form{
	height:280px;
	width:300px;
	padding-top:20px;
	border:2px solid white;
	margin:20px auto;
	color:white;
	text-align:center;
	border-top-left-radius:2rem;
	border-bottom-right-radius:2rem;
	box-shadow:0px 0px 30px white;
	}
	input[type="email"],input[type="text"],input[type="tel"]{
	width:70%;
	}
	h1{
	margin:100px auto;
	font-size:40px;
	color:aqua;
	text-align:center;
	}
	.s{
	margin:0rem auto;
	color:green;}
	.f{
	margin:0rem auto;
	color:red;}
</style>
</head>
<body>
<%Student s=(Student)session.getAttribute("s"); %>
<header>
<h1>Update <%=s.getName() %>'s Data</h1>
</header>

<form action="updateaccount" method="post">
	
	<label>Name:</label><br>
	<input type="text" name="name" value="<%=s.getName() %>"><br>
	<label>Phone:</label><br>
	<input type="tel" name="phone" value="<%=s.getPhone() %>"><br>
	<label>Mail ID:</label><br>
	<input type="email" name="mail" value="<%=s.getMail() %>"><br>
	<label>Branch:</label><br>
	<input type="text" name="branch" value="<%=s.getBranch() %>"><br>
	<label>Location:</label><br>
	<input type="text" name="loc" value="<%=s.getLoc() %>"><br><br>
	<input type="submit" value="update"><br><br>
	<a href="Dashboard.jsp">Dashboard</a><br><br>
	<%String su=(String)request.getAttribute("success");
	if(su!=null){%>
		<h3 class="s"><%=su %></h3>
		<%}
	String f=(String)request.getAttribute("failure");
	if(f!=null){%>
		<h3 class="f"><%=f %></h3>
		<%} %>
</form>
</body>
</html>