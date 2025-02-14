<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
	color:white;
	background-color:black;
	text-decoration:none;
	}
	form{
	height:200px;
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
	input[type="password"]{
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
<h1>Reset Password</h1>
	<form action="rp" method="post">
	<br>
		<label>password:</label><br>
		<input type="password" name="pass"><br><br>
		<label>Confirm password:</label><br>
		<input type="password" name="cpass"><br><br>
		<input type="submit" value="reset"><br><br>
		<a href="Dashboard.jsp">Dashboard</a>
	</form>
	<%String s=(String)request.getAttribute("success");
	if(s!=null){%>
	<h3 class="s"><%=s %></h3>
	<%}
	String f=(String)request.getAttribute("failure");
	if(f!=null){%>
	<h3 class="f"><%=f %></h3>
	<%} %>
</body>
</html>
