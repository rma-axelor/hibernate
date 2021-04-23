package com.JDBC;

import java.sql.*;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
		String url = "jdbc:postgresql://localhost:5432/axelor";
		String uname = "axelor";
		String pass = "axelor";
		
		String qry = "Select * from Student where rollno = 30";
		
		Class.forName("org.postgresql.Driver");
		
		Connection con = DriverManager.getConnection(url,uname,pass);
		
		Statement st = con.createStatement();
		ResultSet rs= st.executeQuery(qry);
		
		rs.next();
		String name = rs.getString("name");
		
		System.out.println(name);
		
	}

}
