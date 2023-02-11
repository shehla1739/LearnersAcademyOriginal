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
import com.ksk.lms.entities.Subject;
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;
@WebServlet("/adminDeleteSubject")
public class AdminDeleteSubjectController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		SubjectService subjectService = new SubjectServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		int subjectId = Integer.parseInt(req.getParameter("stubjectId2"));		
		//out.println("<br> Subject id  : " + subjectId );
	
		Subject tempSubject = subjectService.getSubject(subjectId);
		out.println("<br> Subject Details  : " + tempSubject );
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
		//	session.delete(tempSubject);
			tx.commit();			
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		 //GET Objects	   		
		List<Subject> subjects = subjectService.getAllSubject();				
		//out.println("subjects: " + subjects);	
		req.setAttribute("subjects", subjects);
		RequestDispatcher rd=req.getRequestDispatcher("listSubject.jsp");
		rd.forward(req, resp); 		
	}
	
}
