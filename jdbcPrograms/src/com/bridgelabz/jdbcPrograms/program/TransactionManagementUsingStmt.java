package com.bridgelabz.jdbcPrograms.program;

import java.sql.*;

public class TransactionManagementUsingStmt {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");
		con.setAutoCommit(false);  
		Statement stmt=con.createStatement();  
		stmt.executeUpdate("insert into Employee values('abhi','31',40000,'234123623')");  
		stmt.executeUpdate("insert into Employee values('sabha','33',80000,'1254326446')");  	  
		con.commit();  
		con.close();  
		stmt.close();
	}
}