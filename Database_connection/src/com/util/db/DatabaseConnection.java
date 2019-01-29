package com.util.db;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DatabaseConnection
{
	public static void main(String[] args){
		Connection con=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customer1","root","");
			
			 Statement stm=con.createStatement();
			 
			 ResultSet rs=stm.executeQuery("select * from cust_info");
			 
			 while(rs.next())
				 System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
		}
		catch(Exception e){
			System.out.println(e);
		}finally
		{
			try
			{
				con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		
	}
}
