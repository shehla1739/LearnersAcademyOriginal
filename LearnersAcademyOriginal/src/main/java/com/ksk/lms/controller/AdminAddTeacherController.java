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

@WebServlet("/adminAddteacher")
public class AdminAddTeacherController extends HttpServlet{
	private static final long serialVersionUID = 1L;
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	TeacherService teacherService=new TeacherServiceImpl();
	resp.setContentType("text/html");
	PrintWriter out = resp.getWriter();
	
	
	String teacherName= req.getParameter("teacherName");
	String designation= req.getParameter("designation");
	String skill= req.getParameter("skill");
	String address= req.getParameter("address");
	int subjectId=Integer.parseInt(req.getParameter("subjectId"));
	out.println("<br> Teacher name  : " + teacherName);
		
	Teacher tempTeacher = new Teacher(teacherName, address, designation, skill);
	
	/*
	//add subject to Teacher
	tempTeacher.addSubject(tempSubject);
	*/
	//save Teacher
	teacherService.addTeacher(tempTeacher);
	 //GET Objects	   			

	List<Teacher> teachers = teacherService.getAllTeacher();
	
	//out.println("teachers: " + teachers);	
	req.setAttribute("teachers", teachers);
	RequestDispatcher rd=req.getRequestDispatcher("listTeacher.jsp");
	rd.forward(req, resp);

}
	
}
