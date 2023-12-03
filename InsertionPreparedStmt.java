package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.*;
public class InsertionPreparedStmt {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int sno;
		String name;
		System.out.println("Enter the user Serial number:");
		sno=sc.nextInt();
		System.out.println("Enter the user name:");
		name=sc.next();
		System.out.println(" Details Entered sucessfully.");
		//driver class loading
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connection object creation.
		String s1 ="jdbc:mysql://localhost:3306/pkEnterprise";
		String s2 ="root";
		String s3 = "prasadnaidu";
		 Connection con =DriverManager.getConnection(s1,s2,s3);
		 // using prepared Statement and object creation.
		 PreparedStatement ps= con.prepareStatement("insert into pkemp values(?,?);");
		ps.setInt(1, sno);
		ps.setString(2,name);
//		 System.out.println(rs);
		 int row=ps.executeUpdate();
		 
		 ResultSet rs=ps.executeQuery("Select * from pkemp;");

		 while(rs.next())
		 {
			 
			 System.out.println(rs.getInt(1)+" "+rs.getString(2));
		 }
		
		 if(row>0) {
		 System.out.println("updatation done.");
		 }
		 else
		 {
			 System.out.println("nothing");
		 }

	}

}
