package com.thinkitive;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public registrationServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		dbConnection db = new dbConnection();
		
		List s = new ArrayList();
		s.add(request.getParameter("name"));
		s.add(request.getParameter("email"));
		s.add(request.getParameter("rPassword"));
		s.add(request.getParameter("password_confirm"));
		
		db.Insert(s);
		PrintWriter out = response.getWriter();
		out.println("Data Added");
	}

}
