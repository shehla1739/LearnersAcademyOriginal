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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.ksk.lms.config.HibConfig;

import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminDeleteTeacher")
public class AdminDeleteTeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		TeacherService teacherService = new TeacherServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		int teacherId = Integer.parseInt(req.getParameter("stubjectId2"));		
		out.println("<br> Teacher ID  : " + teacherId  );

		Teacher tempTeacher = teacherService.getTeacher(teacherId);
		out.println("<br> Teacher Details  : " + tempTeacher );
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
		//	session.delete(tempTeacher);
			tx.commit();			
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		 //GET Objects	   		
		List<Teacher> teachers = teacherService.getAllTeacher();				
		//out.println("Teachers: " + teachers);	
		req.setAttribute("teachers", teachers);
		RequestDispatcher rd=req.getRequestDispatcher("listTeacher.jsp");
		rd.forward(req, resp); 		

	}

}
