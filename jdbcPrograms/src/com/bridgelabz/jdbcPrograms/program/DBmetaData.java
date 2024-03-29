package com.bridgelabz.jdbcPrograms.program;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class DBmetaData 
{
	public static void main(String args[]){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "ninja");
			DatabaseMetaData dbmd=connection.getMetaData();  

			System.out.println("Driver Name: "+dbmd.getDriverName());  
			System.out.println("Driver Version: "+dbmd.getDriverVersion());  
			System.out.println("UserName: "+dbmd.getUserName());  
			System.out.println("Database Product Name: "+dbmd.getDatabaseProductName());  
			System.out.println("Database Product Version: "+dbmd.getDatabaseProductVersion());  
			connection.close();  
		}
		catch(Exception e)
		{
			System.out.println(e);
		}  
	}  
}
