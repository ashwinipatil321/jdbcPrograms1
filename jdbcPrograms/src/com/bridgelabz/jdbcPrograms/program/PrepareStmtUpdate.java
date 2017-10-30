package com.bridgelabz.jdbcPrograms.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrepareStmtUpdate {
public static void main(String[] args) {
	String query="update MySchema.Employee set employeeName=? where EmployeecId=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ninja");
		PreparedStatement preparedStatmt = connection.prepareStatement(query);
		preparedStatmt.setString(1, "sonal");
		preparedStatmt.setInt(2, 5);
		int i=	preparedStatmt.executeUpdate();
		System.out.println("result:"+i);
	} catch (ClassNotFoundException | SQLException e) {
	
		e.printStackTrace();
	}
}
}
