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


import com.ksk.lms.dao.SubjectDao;
import com.ksk.lms.dao.SubjectDaoImpl;
import com.ksk.lms.dao.TeacherDao;
import com.ksk.lms.dao.TeacherDaoImpl;
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminListOTeachers")
public class AdminListOfTeacherController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TeacherService teacherService = new TeacherServiceImpl();
		SubjectService subjectService =new SubjectServiceImpl();
		String message =" Add Student";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<h1> " + message + "</h1>");
		
		 //GET Objects	   			
		   
			// get the Teachers  from db
				int theId = 2;
					
				List<Teacher> teachers = teacherService.getAllTeacher();
						
				//out.println("teachers: " + teachers);	
				req.setAttribute("teachers", teachers);
				RequestDispatcher rd=req.getRequestDispatcher("listTeacher.jsp");
				rd.forward(req, resp);					

	}
	
}
