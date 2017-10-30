package com.bridgelabz.jdbcPrograms.program;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcConnection
{
	public static void main(String[] args) 
	{
		Connection connection=null;
		Statement stmt=null;
		ResultSet rs=null;
		//String sql2="DELETE FROM MyStudent [WHERE Student_id=2]";
		String sql1="INSERT INTO MySchema.Student VALUES('meena',10,32156)";
		String sql="SELECT * FROM MySchema.Student";
		String query="Delete from MySchema.Student where Student_Id=5";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drive load successfully..........");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306","root","ninja");
			System.out.println("Connection Establish Successfully......");
			stmt= connection.createStatement();
			System.out.println("Platfrom Created Successfully.......");
			stmt.execute(sql1);
			System.out.println("Inserted Successfully......");
			rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3));
			}
			System.out.println("Retrive Data from table.......");
			stmt.execute(query);
			System.out.println("Deleted");
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
				try 
				{
					rs.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}