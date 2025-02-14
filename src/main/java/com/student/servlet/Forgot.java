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
@WebServlet("/forgot")
public class Forgot extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=resp.getWriter();
		Student s=new Student();
		StudentDAO sdao =new StudentDAOImp1();
		s=sdao.getStudent(req.getParameter("mail"),Long.parseLong(req.getParameter("phone")));
		if(s!=null)
		{
			if(req.getParameter("pass").equals(req.getParameter("cpass")))
			{
				s.setPassword(req.getParameter("pass"));
				if(sdao.updateStudent(s))
				{
					req.setAttribute("s","Password updated Successfully");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.forward(req, resp);
//					pw.println("<h1 style=\"color:green;\">Password updated Succesfully</h1>");
				} 
				else
				{
//					pw.println("<h1 style=\"color:red;\">update failed</h1>");
					req.setAttribute("f","failed to update Password");
					RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
					rd.forward(req, resp);
				}
			}
			else
			{
//				pw.println("<h1 style=\"color:red;\">Password missmatch</h1>");
				req.setAttribute("f","Password Missmatch");
				RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
				rd.forward(req, resp);
			}	
		}
		else
		{
//			pw.println("<h1 style=\"color:red;\">wrong mailId or phone</h1>");
			req.setAttribute("f","Wrong MailId or Phone Number");
			RequestDispatcher rd=req.getRequestDispatcher("Forgot.jsp");
			rd.forward(req, resp);
		}

	}
	
}
