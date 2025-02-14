<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Forget password</title>
<style type="text/css">
	*{
	color:white;
	background-color:black;
	text-decoration:none;
	}
	form{
	height:350px;
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
	input[type="email"],input[type="password"],input[type="tel"]{
	width:70%;
	}
	h1{
	margin:100px auto;
	font-size:40px;
	color:aqua;
	text-align:center;
	}
	.f{
	margin:0rem auto;
	color:red;}
</style>
</head>
<body>
<h1>Welcome to Forgot password page</h1>
<form action="forgot" method="post">
	<br>
	Enter your mail Id:<br>
	<input type="email" name="mail" placeholder="enter your mailid" required><br><br>
	Enter your phone number:<br>
	<input type="tel" name="phone" placeholder="enter your phone number" required><br><br>
	Enter the new password:<br>
	<input type="password"  name="pass" placeholder="enter the password" required><br><br>
	Confirm the password:<br>
	<input type="password" name="cpass" placeholder="Confirm password" required><br><br>
	<input type="submit" value="reset">
	<button><a href="Login.jsp">login</a></button>
</form>
	<%String f=(String)request.getAttribute("f");
	if(f!=null){ %>
	<h1 class="f"><%=f %></h1>
	<%} %>
</body>
</html>