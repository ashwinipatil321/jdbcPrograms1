package com.bridgelabz.jdbcPrograms.program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertStatment
{

	public static void main(String[] args) 
	{
		Connection connection=null;
		Statement stmt=null;
		String sql1="INSERT INTO MySchema.Student VALUES('meena',10,32156)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive load successfully..........");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ninja");
			System.out.println("Connection Establish Successfully......");
			stmt= connection.createStatement();
			System.out.println("Platfrom Created Successfully.......");
			stmt.execute(sql1);
			System.out.println("Inserted Successfully......");
		}
		catch (ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					stmt.close();
				}
				catch (SQLException e)
				{

					e.printStackTrace();
				}
			}
		}
	}
}

