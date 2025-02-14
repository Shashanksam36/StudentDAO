package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.*;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=resp.getWriter();
		HttpSession session=req.getSession(true);
		StudentDAO sdao=new StudentDAOImp1();
		Student s=sdao.getStudent(req.getParameter("mail"),req.getParameter("pass"));
		if(s!=null)
		{
//			pw.println("<h1 style=\"color:green;\">login sucessfull welcome "+s.getName()+"</h1>");
//			req.setAttribute("s",s);
			session.setAttribute("s",s);
			RequestDispatcher rd=req.getRequestDispatcher("Dashboard.jsp");
			rd.forward(req, resp);
		}
		else
		{
//			pw.println("<h1 style=\"color:red;\">login failed</h1>");
			req.setAttribute("failure","Failed to login");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
			
	}

}
