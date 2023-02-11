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
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.AcademicClassService;
import com.ksk.lms.service.AcademicClassServiceImpl;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminListOfClasses")
public class AdminListOfAcademicClass extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AcademicClassService academicClassService = new AcademicClassServiceImpl();
		String message =" Academic Classes";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1> " + message + "</h1>");
		
		 //GET Objects	   			
		   
			// get the Classes  from db
									
				List<AcademicClass> academicClasss = academicClassService.getAllAcademicClass();						
				out.println("academicClasss: " + academicClasss);	
				
				req.setAttribute("academicClasss", academicClasss);
				RequestDispatcher rd=req.getRequestDispatcher("listAcademicClass.jsp");
				rd.forward(req, resp);
				
	}
	
}
