package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;

import com.student.connection.ConnectorFactory;
import com.student.dto.Student;

public class StudentDAOImp1 implements StudentDAO {
	private Connection con;
	
	public StudentDAOImp1()
	{
		this.con=ConnectorFactory.requestConnection();
	}
	@Override
	public boolean insertStudent(Student s) {
		PreparedStatement ps=null;
		int i=0;
		String query="insert into student values (0,?,?,?,?,?,?,sysdate())";
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,s.getName());
			ps.setLong(2,s.getPhone());
			ps.setString(3,s.getMail());
			ps.setString(4,s.getBranch());
			ps.setString(5,s.getLoc());
			ps.setString(6,s.getPassword());
			
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(i>0)
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean updateStudent(Student s) {
		PreparedStatement ps=null;
		String query="update student set name=?,phone=?,mail=?,branch=?,location=?,password=? where id=?";
		int i=0;
			try {
				ps=con.prepareStatement(query);
				ps.setString(1,s.getName());
				ps.setLong(2,s.getPhone());
				ps.setString(3,s.getMail());
				ps.setString(4,s.getBranch());
				ps.setString(5,s.getLoc());
				ps.setString(6,s.getPassword());
				ps.setInt(7,s.getId());
				
				i=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>0) {
				return true;
			}
			else {
				return false;
			}
	}

	@Override
	public boolean deleteStudent(Student s) {
		// TODO Auto-generated method stub
		int res=0;
		try {
			PreparedStatement ps=con.prepareStatement("delete from Student where id=?");
			ps.setInt(1, s.getId());
		   res=ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res==1?true:false;
	}

	@Override
	public Student getStudent(String mail, String password) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE MAIL=? AND PASSWORD=?";
		ResultSet rs=null;
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1, mail);
			ps.setString(2, password);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("Id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("Phone"));
				s.setMail(rs.getString("Mail"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("Date"));
				
			}
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public ArrayList<Student> getStudent() {
		// TODO Auto-generated method stub
		ArrayList<Student> students=new ArrayList<Student>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Student s=null;
		String qurey="select * from student where id!=1";
		try {
			ps=con.prepareStatement(qurey);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("Id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("Phone"));
				s.setMail(rs.getString("Mail"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("Date"));
				students.add(s);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
	@Override
	public Student getStudent(String mail, Long phone) {		
	PreparedStatement ps=null;
	String query="SELECT * FROM STUDENT WHERE MAIL=? AND phone=?";
	ResultSet rs=null;
	Student s=null;
	try {
		ps=con.prepareStatement(query);
		ps.setString(1, mail);
		ps.setLong(2, phone);
		rs=ps.executeQuery();
		while(rs.next()) {
			s=new Student();
			s.setId(rs.getInt("Id"));
			s.setName(rs.getString("name"));
			s.setPhone(rs.getLong("Phone"));
			s.setMail(rs.getString("Mail"));
			s.setBranch(rs.getString("Branch"));
			s.setLoc(rs.getString("location"));
			s.setPassword(rs.getString("password"));
			s.setDate(rs.getString("Date"));
			
		}
	}catch(SQLException e){
		
		e.printStackTrace();
	}
	return s;
}
	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		PreparedStatement ps=null;
		String query="SELECT * FROM STUDENT WHERE id=?";
		ResultSet rs=null;
		Student s=null;
		try {
			ps=con.prepareStatement(query);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("Id"));
				s.setName(rs.getString("name"));
				s.setPhone(rs.getLong("Phone"));
				s.setMail(rs.getString("Mail"));
				s.setBranch(rs.getString("Branch"));
				s.setLoc(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("Date"));
				
			}
		}catch(SQLException e){
			
			e.printStackTrace();
		}
		return s;
	}
}
