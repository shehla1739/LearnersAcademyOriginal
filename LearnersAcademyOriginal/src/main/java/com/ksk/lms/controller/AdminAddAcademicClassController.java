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
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminAddAcademicClass")
public class AdminAddAcademicClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AcademicClassService academicClassService=new AcademicClassServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		String academicClassName= req.getParameter("academicClassName");
		int duration= Integer.parseInt(req.getParameter("duration"));
		
		out.println("<br> AcademicClass name  : " + academicClassName + " : " + duration);
			
		AcademicClass tempAcademicClass = new AcademicClass(academicClassName, duration);
		/*
		//add subject to AcademicClass
		tempAcademicClass.addSubject(tempSubject);
		*/
		//save AcademicClass
		academicClassService.addAcademicClass(tempAcademicClass);
		 //GET Objects	   			

		List<AcademicClass> academicClasss = academicClassService.getAllAcademicClass();
		
		//out.println("academicClasss: " + academicClasss);	
		req.setAttribute("academicClasss", academicClasss);
		RequestDispatcher rd=req.getRequestDispatcher("listAcademicClass.jsp");
		rd.forward(req, resp);

	}

}
