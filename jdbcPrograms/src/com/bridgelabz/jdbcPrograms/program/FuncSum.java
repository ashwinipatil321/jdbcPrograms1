package com.bridgelabz.jdbcPrograms.program;
import java.sql.*;  
public class FuncSum {
	public static void main(String[] args) throws Exception{  
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");
		CallableStatement stmt=con.prepareCall("{?= call sum4(?,?)}");  
		stmt.setInt(2,10);  
		stmt.setInt(3,43);  
	stmt.registerOutParameter(1,Types.INTEGER);  
		stmt.executeUpdate();  

		System.out.println(stmt.getInt(1));  
	}  
}  

