package com.bridgelabz.jdbcPrograms.program;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class TranstionManagementUsingPStmt 
{
	public static void main(String[] args) 
	{
		java.sql.PreparedStatement ps=null;
		PreparedStatement ps1=null;

		Connection con =null;
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");
			con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");
			con.setAutoCommit(false);  
			
			ps	=con.prepareStatement("insert into Employee values(?,?,?,?)");  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

			System.out.println("Enter id......");  
			String s1=br.readLine();  
			int id=Integer.parseInt(s1);  

			System.out.println("Enter name.....");  
			String name=br.readLine();  

			System.out.println("Enter salary.....");  
			String s3=br.readLine();  
			double salary=Double.parseDouble(s3);

			System.out.println("Enter Mobile Number.....");  
			String mobileNumber=br.readLine();  

			ps.setString(1,name); 
			ps.setInt(2,id);  
			ps.setDouble(3,salary); 
			ps.setString(4,mobileNumber);
			ps.executeUpdate();  
			con.commit();  
			System.out.println("record successfully saved");  
 
			ps1=con.prepareStatement("insert into Student values(?,?,?)");
			System.out.println("Enter name.....");  
			String name1=br.readLine();  

			System.out.println("Enter id......");  
			String sid1=br.readLine();  
			int sid=Integer.parseInt(sid1);  

			System.out.println("Enter Mobile Number.....");  
			String mobileNumber1=br.readLine();  
			
			ps1.setString(1,name1); 
			ps1.setInt(2,sid);  
			ps1.setString(4,mobileNumber1);
			ps1.executeUpdate();  
			con.commit();  
			System.out.println("record successfully saved"); 
		}
		catch(Exception e)
		{
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}  
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
