package com.thinkitive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class dbConnection {
	private Connection con;
	private PreparedStatement ps;
	private Statement st,st1;
	private ResultSet results;
	
	public dbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Statement createConnection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "root");
			System.out.println("Connection Established");
			st = con.createStatement();
			return st;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void Read() {
		try {
			st1 = createConnection();
			results = st1.executeQuery("SELECT * FROM loginForm");
			while (results.next()) {
				  System.out.println(results.getString("name") + " " + results.getString("email") + " " 
			+ results.getString("password") + " " + results.getString("password_confim"));
			}
			closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Insert(List l1) {
		try {
			st1 = createConnection();
			ps = con.prepareStatement("insert into loginForm values(?,?,?,?)");
			int c=1;
			for(Object temp:l1) {
				ps.setString(c, (String) temp);
				c = c+1;
			}
			ps.execute();
			closeConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkCredential(String email, String password) {
		try {
			st1 = createConnection();
			results = st1.executeQuery("SELECT * FROM loginForm");
			while (results.next()) {
				  if(results.getString("email") == email && results.getString("password") == password) {
					  return true;
				  }
			}
			closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
