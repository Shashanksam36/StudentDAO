<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login page</title>
<style type="text/css">
	*{
	color:white;
	background-color:black;
	text-decoration:none;
	}
	form{
	height:250px;
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
	input[type="email"],input[type="password"]{
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
	<h1>Welcome to Login Page</h1>
	<form action="login" method="post"><br>
		Enter your Mail Id:<br>
		<input type="email" name="mail" placeholder="enter your Mail Id" required><br><br>
		Password:<br>
		<input type="password" name="pass" placeholder="password" required><br><br>
		<input type="submit" value="Login"><br><br>
		<a href="Forget.html">forget password?</a>
		<a href="StudentSignup.html">New User!</a>
	</form>
<% String s=(String)request.getAttribute("s"); 
	if(s!=null){%>
	<h1 class="s"><%=s %></h1>
	<%} %>
	<%String f=(String)request.getAttribute("failure"); 
	if(f!=null){%>
	<h1 class="f"><%=f %></h1>
	<%} %>
</body>
</html>