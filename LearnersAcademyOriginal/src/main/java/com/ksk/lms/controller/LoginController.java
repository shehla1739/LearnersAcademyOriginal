package com.ksk.lms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ksk.lms.entities.User;
import com.ksk.lms.service.UserService;
import com.ksk.lms.service.UserServiceImpl;
@WebServlet("/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		User user=userService.get(username, password);
		//If user is Admin the forward to adminHome page
		if(user!=null && user.getUserType().equals("admin"))
		{
			HttpSession session=req.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=req.getRequestDispatcher("adminHome.jsp");
			rd.forward(req, resp);
		}
		else  //if user is normal user, then forward to index page
		{
			req.setAttribute("msg", "Username/Password is invalid");
			RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}

}
