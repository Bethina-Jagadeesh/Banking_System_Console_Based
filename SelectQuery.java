package com.JDBCConnectivity;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// driver class loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection object creation.
		String s1 ="jdbc:mysql://localhost:3306/pkEnterprise";
		String s2 ="root";
		String s3 = "prasadnaidu";
		 Connection con =DriverManager.getConnection(s1,s2,s3);
		 //step ->3  Statement object creation
		 Statement s= con.createStatement();
		 ResultSet rs=s.executeQuery("Select * from pkemp;");
		 System.out.println(rs);
//		 while(rs.next())
//		 {
//			 
//			 System.out.println(rs.getInt("sno")+" "+rs.getString("name"));
//		 }
//		 
		 while(rs.next())
		 {
			 
			 System.out.println(rs.getInt(1)+" "+rs.getString(2));
		 }
		 
		//System.out.println("connection created sucesssfully.");
	}

}
