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
//Login
//create table loginForm(name varchar(50),email varchar(50),password varchar(50), password_confim varchar(50));

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
        public loginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		dbConnection db = new dbConnection();
		PrintWriter out = response.getWriter();
		if(db.checkCredential(user, pass)) {
			out.println("Login Successful");
		}
		else {
			out.println("Login Unsuccessful");
		}
		
	}

}
