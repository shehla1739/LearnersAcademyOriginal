package com.ksk.lms.controller;

import java.io.IOException;
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

@WebServlet("/addSubject")
public class SubjectController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private SubjectService subjectService=new SubjectServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subjectName=req.getParameter("subjName");
		Subject subject=new Subject();
		subject.setName(subjectName);	
		//subjectService.addSubject(subject);	
		/*
		List<Subject> subjects = subjectService.getSubjects();
		req.setAttribute("subjectList", subjects);
		req.setAttribute("msg","Subject added successfully");
		RequestDispatcher rd=req.getRequestDispatcher("adminHome.jsp");
		rd.forward(req, resp);	*/
	}
}
