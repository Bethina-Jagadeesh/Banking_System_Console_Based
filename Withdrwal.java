package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import com.mysql.cj.xdevapi.Statement;

public class Withdrwal {
	public static void getMoney(String pw)throws ClassNotFoundException, SQLException
{
		 System.out.println("");
		 System.out.println("");

		System.out.println("---------------WELCOME TO THE Withdrawal---------------");
		System.out.println("");
		System.out.println("");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("");
		System.out.print("Enter the Amount to Withrwal:"); 
		int wd=sc.nextInt();
		System.out.println("");
		System.out.println("");
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
		 if(am>=wd)
		 {
			 finalam=am-wd;
			 PreparedStatement ps= con.prepareStatement("update register set  amount=? where ac_id=?;");
					ps.setString(2, pw);
					ps.setInt(1,finalam);
					 int row=ps.executeUpdate();
					 if(row>0) {System.out.println("");
					 System.out.println("");
					 System.out.println("");
						
						 System.out.println("updatation done.");
						 System.out.println("");
						 System.out.println("");
							
						 }
						 else
						 {
							 System.out.println("");
							 System.out.println("");
								
							 System.out.println("SomeThing Went wrong Please try again.");
						 
							 System.out.println("");
							 System.out.println("");
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
