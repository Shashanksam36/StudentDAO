package com.student.servlet;

import java.io.IOException;
import com.student.dao.*;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class Delete extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StudentDAO sdao=new StudentDAOImp1();
		Student st=sdao.getStudent(Integer.parseInt(req.getParameter("id")));
		if(st!=null)
			if(sdao.deleteStudent(st)) 
			{
				req.setAttribute("success", "data deleted sucessfully");
				RequestDispatcher rd=req.getRequestDispatcher("Viewdata.jsp");
				rd.forward(req, resp);
			}
			else
			{
				req.setAttribute("failure", "failed to delete data");
				RequestDispatcher rd=req.getRequestDispatcher("Viewdata.jsp");
				rd.forward(req, resp);
			}
		else
		{
			req.setAttribute("failure", "failed to get the value of the data to be deleted");
			RequestDispatcher rd=req.getRequestDispatcher("Viewdata.jsp");
			rd.forward(req, resp);
		}
	}

}
