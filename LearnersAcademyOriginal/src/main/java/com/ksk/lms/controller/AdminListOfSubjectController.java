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

import com.ksk.lms.entities.Subject;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;

@WebServlet("/adminListOSubjects")
public class AdminListOfSubjectController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		SubjectService subjectService =new SubjectServiceImpl();
		String message =" Add Subject";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1> " + message + "</h1>");
		
		 //GET Objects	   			

				List<Subject> subjects = subjectService.getAllSubject();
						
				//out.println("subjects: " + subjects);	
				req.setAttribute("subjects", subjects);
				RequestDispatcher rd=req.getRequestDispatcher("listSubject.jsp");
				rd.forward(req, resp);
			
	}

}
