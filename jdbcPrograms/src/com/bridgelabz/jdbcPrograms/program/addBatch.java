package com.bridgelabz.jdbcPrograms.program;

import java.sql.*;

public class addBatch {
	public static void main(String args[])throws Exception{  
		Connection con= null;
		Class.forName("com.mysql.jdbc.Driver");
		con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");  
		con.setAutoCommit(false);  
		  
		Statement stmt=con.createStatement();  
		stmt.addBatch("insert into Employee values('Abc',45,40000,'23512453')");  
		stmt.addBatch("insert into Employee values('umesh',67,50000,'4637467')");  
		stmt.executeBatch();
		con.commit(); 
		System.out.println("inserted");
		con.close();  
		stmt.close();
	}
	}  

