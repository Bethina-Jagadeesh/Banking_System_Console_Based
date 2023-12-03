package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceEnquery {
	public static void getBal(String pw) throws ClassNotFoundException, SQLException
	{
		
		 System.out.println("");
		 System.out.println("");
System.out.println("---------------WELCOME TO THE BalanceEnquery---------------");
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection object creation.
		String s1 ="jdbc:mysql://localhost:3306/PKBANKS";
		String s2 ="root";
		String s3 = "prasadnaidu";
		 Connection con =DriverManager.getConnection(s1,s2,s3);
		 //step ->3  Statement object creation
		 Statement s= con.createStatement();
		 ResultSet rs=s.executeQuery("Select * from register where ac_id='"+pw+"';");
		 rs.next();
		 int am=rs.getInt(7);
		 System.out.println("");
		 System.out.println("");

	 System.out.println("The amount on your Account is:"+am);
		 System.out.println("");
		 System.out.println("");


	}
}
