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
import com.ksk.lms.entities.AcademicClass;
import com.ksk.lms.entities.Teacher;
import com.ksk.lms.service.AcademicClassService;
import com.ksk.lms.service.AcademicClassServiceImpl;
import com.ksk.lms.service.TeacherService;
import com.ksk.lms.service.TeacherServiceImpl;

@WebServlet("/adminDeleteAcademicClass")
public class AdminDeleteAcademicClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		AcademicClassService academicClassService = new AcademicClassServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		int academicClassId = Integer.parseInt(req.getParameter("academicClassId2"));		
		out.println("<br> AcademicClass ID  : " + academicClassId  );

		AcademicClass tempAcademicClass = academicClassService.getAcademicClass(academicClassId);
		out.println("<br> AcademicClass Details  : " + tempAcademicClass );
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(tempAcademicClass);
			tx.commit();			
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		 //GET Objects	   		
		List<AcademicClass> academicClasss = academicClassService.getAllAcademicClass();				
		//out.println("AcademicClasss: " + academicClasss);	
		req.setAttribute("academicClasss", academicClasss);
		RequestDispatcher rd=req.getRequestDispatcher("listAcademicClass.jsp");
		rd.forward(req, resp); 		
	}

}
