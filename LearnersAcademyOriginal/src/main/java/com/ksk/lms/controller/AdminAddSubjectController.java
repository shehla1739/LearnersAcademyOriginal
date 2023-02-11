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
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminAddSubject")
public class AdminAddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService teacherService=new TeacherServiceImpl();
		SubjectService subjectService = new SubjectServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		String subjectName= req.getParameter("subjectName");
		int teacherId=Integer.parseInt(req.getParameter("teacherId"));
		//out.println("<br> Subject name  : " + subjectName + ": " + teacherId);
		
		Teacher tempTeacher = teacherService.getTeacher(teacherId);
		Subject tempSubject = new Subject(subjectName);
		
		//add subject to Teacher
		tempTeacher.addSubject(tempSubject);
		
		//save Subject
		subjectService.addSubject(tempSubject);
		 //GET Objects	   			

		List<Subject> subjects = subjectService.getAllSubject();
				
		//out.println("subjects: " + subjects);	
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd=req.getRequestDispatcher("listSubject.jsp");
		rd.forward(req, resp);
	}
}
