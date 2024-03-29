package com.bridgelabz.jdbcPrograms.program;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class AddBatchUsingPStmt {
	public static void main(String args[]) throws SQLException, IOException{  
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con	=DriverManager.getConnection("jdbc:mysql://localhost:3306/MySchema","root","ninja");


			con.setAutoCommit(false);  

			java.sql.PreparedStatement	ps=con.prepareStatement("insert into Employee values(?,?,?,?)");  


			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

			while(true)
			{


				System.out.println("Enter id......");  
				String s1;
				s1 = br.readLine();
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
				ps.addBatch();  
				System.out.println("Want to add more records y/n");  
				String ans=br.readLine();  
				if(ans.equals("n"))
				{  
					break;  
				}
			}

			ps.executeBatch();  

			System.out.println("record successfully saved");  

			con.close(); 
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}  

	}	
}	

