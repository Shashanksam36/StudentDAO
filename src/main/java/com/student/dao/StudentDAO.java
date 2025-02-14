package com.student.dao;

import java.util.ArrayList;

import com.student.dto.Student;

public interface StudentDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(int id);
	public Student getStudent(String mail,String password);
	public Student getStudent(String mail,Long phone);
	public ArrayList<Student> getStudent();
}
