<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Signup page</title>
<style>
	*{
	background-color:rgb(0, 0, 0);
	color:white;
	text-decoration:none;
	}
	h1{
	color:blue;
	text-align:center;
	font-size:40px;
	}
	h3{
	font-size:25px;
	color:aqua;
	text-align:center;
	}
	form{
	height:500px;
	width:300px;
	border:2px solid white;
	margin:50px auto;
	color:white;
	text-align:center;
	border-top-left-radius:2rem;
	border-bottom-right-radius:2rem;
	box-shadow:0px 0px 30px white;
	}
	input[type="email"],input[type="text"],input[type="tel"],input[type="password"]{
	width:70%;
	}
	.s{
	color:green;
	}
	.f{
	color:red;
	}
</style>
</head>
<body>
		<h1>Welcome to Sign up page</h1>
		<h3>Application form</h3>
	<form action="signup" method="post"><br>
		Enter your name:<br>
		<input type="text" name="name" placeholder="name" required><br><br>
		Enter the phone number:<br>
		<input type="tel" name="phone" placeholder="phone" required><br><br>
		Enter the Mail Id:<br>
		<input type="email" name="mail" placeholder="MAIL ID" required><br><br>
		Enter the branch:<br>
		<input type="text" name="branch" placeholder="branch" required><br><br>
		Enter the location:<br>
		<input type="text" name="loc" placeholder="location" required><br><br>
		Enter the password:<br>
		<input type="password" name="pass" placeholder="password" required><br><br>
		Confirm the password:<br>
		<input type="password" name="cpass" placeholder="confirm password" required><br><br>
		<input type="submit" value="create accont"><br>
		<a href="Login.html">already have a account?</a>
	</form>
		<% String s=(String)request.getAttribute("success"); %>
		<%if(s!=null) {%>
		<h1 class="s"><%=s %></h1>
		<%} %>
		<%String f=(String)request.getAttribute("failur"); %>
		<%if(f!=null){ %>
		<h1 class="f"><%=f %></h1>
		<%} %>
</body>
</html>