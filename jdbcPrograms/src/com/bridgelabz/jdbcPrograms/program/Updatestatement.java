package com.bridgelabz.jdbcPrograms.program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Updatestatement {
	public static void main(String[] args) 
	{
		Connection connection=null;
		Statement stmt=null;
		String sql="UPDATE MySchema.Student set student_name='soma',mobile_number=12345 where Student_id=10";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive load successfully..........");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ninja");
			System.out.println("Connection Establish Successfully......");
			stmt= connection.createStatement();
			stmt.execute(sql);
			System.out.println("Update Successfully.......");
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



