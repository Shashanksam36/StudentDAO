package com.student.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/l")
public class Logout extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
			session.invalidate();
			req.setAttribute("s", "logged out sucessfully");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req,resp);
		}
		else
		{
			req.setAttribute("failure", "session expired!");
			RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
			rd.forward(req, resp);
		}
	}
	
}
