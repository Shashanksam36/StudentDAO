<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.student.dao.*" %>
<%@page import="com.student.dto.*" %>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student management</title>
<style type="text/css">
	*{
	margin:0rem;
	border:0rem;
	text-decoration:none;
	}
	.name{
	font-size:1.5rem;}
	header{
	background-color:black;
	display:flex;
	color:white;
	padding:1.5rem;
	justify-content:space-between;
	
	}
	a{
	color:gray;
	margin:0rem 0.5rem;
	}
	.logoutb{
	
	color:white;
	border-radius:0.2rem;
	}
	.logout{
	color:white;
	background-color:red;
	}
	.dashboard{
	margin:1rem auto;
	text-align:center;
	font-size:2rem;
	}
	caption{
	margin:1rem 0rem;
	font-size:2rem;
	text-align:left;
	}
	table{
	width:100%;
	text-align:left;
	justify-content:space-between;
	}
	td,th{
	padding:0.5rem 0rem;
	}
	form{
	display:inline;}
</style>
</head>
<body>
	<% Student s=(Student)session.getAttribute("s"); 
	if(s!=null){
	%>
	<header>
		<div>
			<p class="name">Welcome <%=s.getName() %></p>
		</div>
		<div>
		<%if(s.getId()==1){ %><a href="Viewdata.jsp" class="viewd">View data</a><%} %>
			<a href="Reset.jsp">Reset Password</a>
			<a href="Update.jsp">Update Data</a>
			<form action="l" method="post">
			<input class="logout" type="submit" value="logout" >
			</form>
		</div>
	</header>
	<section class="dashboard">
		<h1>Dashboard</h1>
	</section>
	<section class="data">
		<table>
		<caption>View your data</caption>
			<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Mail ID</th>
			<th>Branch</th>
			<th>Location</th>
			</tr>
			<tr>
			<td><%=s.getId() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getMail() %></td>
			<td><%=s.getBranch() %></td>
			<td><%=s.getLoc() %></td>
			</tr>
		</table>
	</section>
	<%}
	else
	{
		request.setAttribute("failure","session exaired!");
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		rd.forward(request,response);
	}%>
</body>
</html>