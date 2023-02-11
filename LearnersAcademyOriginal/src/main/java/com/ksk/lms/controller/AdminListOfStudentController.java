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

import com.ksk.lms.entities.Student;
import com.ksk.lms.entities.Subject;
import com.ksk.lms.service.StudentService;
import com.ksk.lms.service.StudentServiceImpl;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;

@WebServlet("/adminListOfStudents")
public class AdminListOfStudentController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StudentService studentService =new StudentServiceImpl();
		String message =" Add Student";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1> " + message + "</h1>");
		
		 //GET Objects	   			

				List<Student> students = studentService.getAllStudent();
						
				//out.println("students: " + students);	
				req.setAttribute("students", students);
				RequestDispatcher rd=req.getRequestDispatcher("listStudent.jsp");
				rd.forward(req, resp);
			
	}
}
