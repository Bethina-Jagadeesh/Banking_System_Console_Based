package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Deposite {
	public static void putMoney(String pw) throws ClassNotFoundException, SQLException
	{
		System.out.println("---------------WELCOME TO THE Deposite---------------");
		Scanner sc= new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter the Amount to Deposie:");
		int Dp=sc.nextInt();
		int finalam=0;
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
	 System.out.println("The amount on your Account is:"+am);
		 System.out.println("");
		 System.out.println("");
		 if(Dp>0)
		 {
			 finalam=am+Dp;
			 PreparedStatement ps= con.prepareStatement("update register set  amount=? where ac_id=?;");
					ps.setString(2, pw);
					ps.setInt(1,finalam);
					 int row=ps.executeUpdate();
					 if(row>0) {
						 System.out.println("updatation done.");
						 }
						 else
						 {
							 System.out.println("SomeThing Went wrong Please try again.");
						 }
		 System.out.println("The amount on your Account is:"+finalam);
			 
			 System.out.println("");
			 System.out.println("");
		 }
		 else
		 {
			 System.out.println("Insufficent Fund.");
		 }
			
	}

	}
