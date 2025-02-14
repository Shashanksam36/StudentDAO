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
@WebServlet("/rp")
public class Reset extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentDAO sdao=new StudentDAOImp1();
		HttpSession session=req.getSession(false);
		Student s=(Student)session.getAttribute("s");
		//jsp code
//		<label>Mail ID:</label><br>
//		<input type="email" name="mail"><br>
//		<label>phone:</label><br>
//		<input type="tel" name="phone"><br>
//		if(st.getMail().equals((String)req.getParameter("mail"))&&st.getPhone()==(Long)req.getParameter("phone"))
		if(req.getParameter("pass").equals(req.getParameter("cpass")))
		{
//			System.out.println(s);
			s.setPassword(req.getParameter("pass"));
			if(sdao.updateStudent(s))
			{
				req.setAttribute("success","Password reset successfull");
				RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("failure","failed to update");
				RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
				rd.forward(req, resp);
			}
		}
		else
		{
			req.setAttribute("failure","Password Missmatch");
			RequestDispatcher rd=req.getRequestDispatcher("Reset.jsp");
			rd.forward(req, resp);
		}
//		else
//		{
//			req.setAttribute("failure", "Wrong Email ID & phone");
//			RequestDispatcher rd=req.getRequestDispatcher("Rest.jsp");
//			rd.forward(req, resp);
//		}
	}

}
