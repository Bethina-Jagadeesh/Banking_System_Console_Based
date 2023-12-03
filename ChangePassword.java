package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ChangePassword {
	public static void changepw(String pw) throws ClassNotFoundException, SQLException

	{
		System.out.println("---------------WELCOME TO THE Change Password Page---------------");
		Scanner sc= new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter The Old Password:");
		String opw=sc.next();
		System.out.println("");
		System.out.println("Enter The new Password:");
		String npw=sc.next();
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection object creation.
		String s1 ="jdbc:mysql://localhost:3306/PKBANKS";
		String s2 ="root";
		String s3 = "prasadnaidu";
		 Connection con =DriverManager.getConnection(s1,s2,s3);
		 //step ->3  Statement object creation
		 Statement s= con.createStatement();
				 System.out.println("");
		 System.out.println("");
			 PreparedStatement ps= con.prepareStatement("update register set  password=? where ac_id=?;");
					ps.setString(1, npw);
					ps.setString(2,pw);
					 int row=ps.executeUpdate();
					 if(row>0) {
						 System.out.println("updatation done.");
						 }
						 else
						 {
							 System.out.println("SomeThing Went wrong Please try again.");
						 }
		 System.out.println("The Password is Chaned.");
			 
			 System.out.println("");
			 System.out.println("");
		 }
		 
			

	}


	

