package com.bridgelabz.jdbcPrograms.program;
import java.sql.*;
public class callablestatmtProgram
{
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");
			CallableStatement	callstmt=con.prepareCall("{call addRecord(?,?,?)}");  
			callstmt.setString(1,"snehal");
			callstmt.setInt(2,8);
			callstmt.setString(3,"12124332");
			callstmt.execute();
			System.out.println("Successfully Inserted......");  

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
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
