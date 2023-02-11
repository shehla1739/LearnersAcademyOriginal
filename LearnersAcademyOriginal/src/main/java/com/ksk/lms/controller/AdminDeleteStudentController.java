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
import com.ksk.lms.entities.Student;
import com.ksk.lms.entities.Subject;
import com.ksk.lms.service.StudentService;
import com.ksk.lms.service.StudentServiceImpl;
import com.ksk.lms.service.SubjectService;
import com.ksk.lms.service.SubjectServiceImpl;

@WebServlet("/adminDeleteStudent")
public class AdminDeleteStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		StudentService studentService = new StudentServiceImpl();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();		
		
		int studentId = Integer.parseInt(req.getParameter("studentId2"));		
		//out.println("<br> Student id  : " + studentId );
	
		Student tempStudent = studentService.getStudent(studentId);
		out.println("<br> Student Details  : " + tempStudent );
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(tempStudent);
			tx.commit();			
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
		 //GET Objects	   		
		List<Student> students = studentService.getAllStudent();				
		//out.println("students: " + students);	
		req.setAttribute("students", students);
		RequestDispatcher rd=req.getRequestDispatcher("listStudent.jsp");
		rd.forward(req, resp); 		
	}

}
