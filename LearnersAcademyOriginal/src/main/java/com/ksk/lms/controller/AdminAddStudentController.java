package com.ksk.lms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksk.lms.entities.AcademicClass;
import com.ksk.lms.entities.Student;
import com.ksk.lms.entities.Subject;
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.AcademicClassService;
import com.ksk.lms.service.AcademicClassServiceImpl;
import com.ksk.lms.service.StudentService;
import com.ksk.lms.service.StudentServiceImpl;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminAddStudent")
public class AdminAddStudentController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AcademicClassService academicClassService=new AcademicClassServiceImpl();
		StudentService studentService = new StudentServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		String studentName= req.getParameter("studentName");
		String address= req.getParameter("address");
		int age=Integer.parseInt(req.getParameter("age"));
		int academicClassId=Integer.parseInt(req.getParameter("academicClassId"));
		//out.println("<br> Subject name  : " + subjectName + ": " + teacherId);
		
		AcademicClass tempAcademicClass = academicClassService.getAcademicClass(academicClassId);
		Student tempStudent = new Student(studentName, address, age);
		
		//add Student to Academic Class		
		tempAcademicClass.addStudent(tempStudent);
		
		//save Student

		studentService.addStudent(tempStudent);
		
		//GET Objects	   		
		List<Student> students = studentService.getAllStudent();
				
		//out.println("subjects: " + subjects);	
		req.setAttribute("students", students);
		RequestDispatcher rd=req.getRequestDispatcher("listStudent.jsp");
		rd.forward(req, resp);
	}

}
