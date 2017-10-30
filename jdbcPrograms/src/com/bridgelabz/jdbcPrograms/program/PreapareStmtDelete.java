package com.bridgelabz.jdbcPrograms.program;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
public class PreapareStmtDelete {
public static void main(String[] args) {
	try {
		String query="Delete from MySchema.Employee where EmployeeName=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ninja");
		PreparedStatement pstmt =  connection.prepareStatement(query);
		pstmt.setString(1,"Amol");
		pstmt.executeUpdate();
		System.out.println("Deleted.....");
	}
	catch (ClassNotFoundException | SQLException e) {
		
		e.printStackTrace();
	}
	
	
}
}
