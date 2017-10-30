package com.bridgelabz.jdbcPrograms.program;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
public class PepareStmtRetriev {
	public static void main(String[] args) {
		String string="Select * from MySchema.Employee";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ninja");
			PreparedStatement pstmt =  (PreparedStatement) connection.prepareStatement(string);	
			ResultSet resultSet=pstmt.executeQuery();
			System.out.println("employeeName \t employeeId \t empolyeeSalary \t mobileNimber\t");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1)+"\t\t "+resultSet.getInt(2)+"\t\t"+resultSet.getDouble(3)+"\t\t "+resultSet.getString(4));  
			}
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
