package com.bridgelabz.jdbcPrograms.program;

import java.sql.*;

public class ResultSetMetaData1
{
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ninja");
			PreparedStatement ps=connection.prepareStatement("select * from MySchema.Employee");  
			ResultSet rs=ps.executeQuery();  
			ResultSetMetaData rsmd=rs.getMetaData();  
			System.out.println("Total columns: "+rsmd.getColumnCount());  
			System.out.println("Column Name of 1st column: "+rsmd.getColumnName(1));  
			System.out.println("Column Type Name of 1st column: "+rsmd.getColumnTypeName(1));  
			connection.close(); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}  
}  

