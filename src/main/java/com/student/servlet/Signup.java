package com.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.*;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/signup")
public class Signup extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		Student s=new Student();
		StudentDAO sdao=new StudentDAOImp1();
		s.setName(req.getParameter("name"));  //getParameter is used to get the value from the users.
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		if(req.getParameter("pass").equals(req.getParameter("cpass")))
		{
			s.setPassword(req.getParameter("cpass"));
			System.out.println("connection extablished");
			boolean status=sdao.insertStudent(s);
			if(status)
			{
//				System.out.println("Inserted into student sucessfully");
//				out.println("<h1 style=\"color:green;\">Data Inserted sucessfully</h1>");
				req.setAttribute("success","Signup sucessfull");
				RequestDispatcher rd =req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
				
			}
			else
			{
//				out.println("<h1 style=\"color:red;\">Data Insertion failed</h1>");
				req.setAttribute("failur","Failed to Signup");
				RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
//			out.println("<h1 style=\"color:red;\">Password Missmatch</h1>");
//			System.out.println("password missmatch");
			req.setAttribute("failur","Password Missmatch");
			RequestDispatcher rd=req.getRequestDispatcher("Signup.jsp");
			rd.forward(req, resp);
		}	
	}
}
