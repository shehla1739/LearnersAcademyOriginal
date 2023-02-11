package com.ksk.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/addTeacher")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService=new TeacherServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String teacherName=req.getParameter("teacherName");
		String designation=req.getParameter("designation");
		String skill=req.getParameter("skill");
		String address=req.getParameter("address");
		
		Teacher teacher=new Teacher();
		teacher.setName(teacherName);
		teacher.setDesignation(designation);
		teacher.setSkill(skill);
		teacher.setAddress(address);
		
		teacherService.addTeacher(teacher);
		
		req.setAttribute("msg","Teacher added successfully");
		RequestDispatcher rd=req.getRequestDispatcher("adminHome.jsp");
		rd.forward(req, resp);
		
	}
}
