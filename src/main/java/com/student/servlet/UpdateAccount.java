package com.student.servlet;

import java.io.IOException;

import com.student.dto.Student;
import com.student.dao.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updateaccount")
public class UpdateAccount extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session= req.getSession(false);
		StudentDAO sdao=new StudentDAOImp1();
		Student s=(Student)session.getAttribute("s");
		s.setName(req.getParameter("name"));
		s.setPhone(Long.parseLong(req.getParameter("phone")));
		s.setMail(req.getParameter("mail"));
		s.setBranch(req.getParameter("branch"));
		s.setLoc(req.getParameter("loc"));
		if(sdao.updateStudent(s))
		{
			req.setAttribute("success","Data updated successfully");
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
		else
		{
			req.setAttribute("failure","Data failed to updated");
			RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
			rd.forward(req, resp);
		}
	}
	

}
