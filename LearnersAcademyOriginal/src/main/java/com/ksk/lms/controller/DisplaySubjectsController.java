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

@WebServlet("/displaySubjects")
public class DisplaySubjectsController extends HttpServlet{
	private SubjectService subjectService=new SubjectServiceImpl();
	/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Subject> subjects=subjectService.getSubjects();
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd=req.getRequestDispatcher("displaySubject.jsp");
		rd.forward(req, resp);	
	}
	*/
}
