package com.iris.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iris.daos.UserDao;
import com.iris.daosimpl.UserDaoImpl;
import com.iris.models.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String s1=request.getParameter("firstname");
			String s2=request.getParameter("lastname");
			String s3=request.getParameter("gender");
			String s4=request.getParameter("city");
			String s5=request.getParameter("role");
			String s6=request.getParameter("password");
			
			User uObj=new User();
			
			uObj.setFirstName(s1);
			uObj.setLastName(s2);
			uObj.setGender(s3);
			uObj.setCity(s4);
			uObj.setRole(s5);
			uObj.setPassword(s6);
			
			UserDao daoObj=new UserDaoImpl();
			
			boolean b=daoObj.registerUser(uObj);
			if(b) {
					
					RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
					rd.forward(request,response);
			}
			
			
			
			
	}

}
