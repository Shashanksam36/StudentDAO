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
	.delete{
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
		<%String su=(String)request.getAttribute("success"); 
		if(su!=null){%>
		<h1><%=su %></h1>
		<%}
		String fa=(String)request.getAttribute("failure"); 
		if(fa!=null){%>
		<h1><%=su %></h1>
		<%}%>
		<div>
		<a href="Dashboard.jsp">Back</a></div>
	</header>
	<section class="dashboard">
		<h1>Student Data</h1>
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
			<th>Remove</th>
			</tr>
			<%StudentDAO sdao=new StudentDAOImp1();
		ArrayList<Student> sa=sdao.getStudent(); 
		Iterator<Student> it=sa.iterator();
		while(it.hasNext()){
		Student s1=it.next();%>
			<tr>
			<td><%=s1.getId() %></td>
			<td><%=s1.getName() %></td>
			<td><%=s1.getPhone() %></td>
			<td><%=s1.getMail() %></td>
			<td><%=s1.getBranch() %></td>
			<td><%=s1.getLoc() %></td>
			<td><form action="delete" method="post">
			<input type="hidden" name="id" value="<%=s1.getId() %>">
			<input class="delete" type="submit" value="delete"> </form>
			</td>
			</tr>
			<%} %>
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