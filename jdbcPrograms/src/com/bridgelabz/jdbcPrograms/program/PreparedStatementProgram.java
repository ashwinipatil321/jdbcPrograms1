package com.bridgelabz.jdbcPrograms.program;

import java.sql.*;

public class PreparedStatementProgram {
	public static void main(String[] args) {
		String query = "insert into  MySchema.Employee values(?,?,?,?)";
		String query1="Delete from MySchema.Employee where EmployeeName=?";
		String query2="update MySchema.Employee set employeeName=? where EmployeecId=?";
		String string="Select * from MySchema.Employee";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ninja");
			
			PreparedStatement preparedStatmt = connection.prepareStatement(query);
			preparedStatmt.setString(1, "Amol");
			preparedStatmt.setInt(2, 27);
			preparedStatmt.setDouble(3, 25000);
			preparedStatmt.setString(4, "1324323553");
			int result = preparedStatmt.executeUpdate();
			System.out.println("result "+result);
		
			preparedStatmt.setString(1, "komal");
			preparedStatmt.setInt(2, 13);
			preparedStatmt.setDouble(3, 10000);
			preparedStatmt.setString(4, "1265437889");
			int result1 = preparedStatmt.executeUpdate();
			System.out.println("result "+result1);
			
			preparedStatmt.setString(1, "seema");
			preparedStatmt.setInt(2, 25);
			preparedStatmt.setDouble(3, 40000);
			preparedStatmt.setString(4, "34563276874");
			int result2 = preparedStatmt.executeUpdate();
			System.out.println("result "+result2);
			
			
			preparedStatmt.setString(1, "meena");
			preparedStatmt.setInt(2, 24);
			preparedStatmt.setDouble(3, 150000);
			preparedStatmt.setString(4, "234125536");
			int result3 = preparedStatmt.executeUpdate();
			System.out.println("result "+result3);
			
			PreparedStatement preparedStatmt1 = connection.prepareStatement(string);
			ResultSet resultSet=preparedStatmt1.executeQuery();
			System.out.println("employeeName \t employeeId \t empolyeeSalary \t mobileNimber");
			while(resultSet.next())
			{
				System.out.println(resultSet.getString(1)+"\t\t"+resultSet.getInt(2)+"\t\t"+resultSet.getDouble(3)+"\t\t "+resultSet.getString(4)+"");  
			}
			System.out.println("Rtrived Successfully");
			
			PreparedStatement preparedStatmt2 = connection.prepareStatement(query1);
			preparedStatmt2.setString(1,"Amol");
			preparedStatmt2.executeUpdate();
			System.out.println("Deleted.....");
			
			PreparedStatement preparedStatm3= connection.prepareStatement(query2);
			preparedStatm3.setString(1, "sonal");
			preparedStatm3.setInt(2, 5);
			int i=	preparedStatm3.executeUpdate();
			System.out.println("result:"+i);
			System.out.println("Update Successfully....");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
