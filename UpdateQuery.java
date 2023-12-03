package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.*;
public class UpdateQuery {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				Scanner sc= new Scanner(System.in);
				int a;
				String b;
				System.out.println("Enter the user Serial number need to be updated:");
				a=sc.nextInt();
//				System.out.println("Enter the user name need to be updated::");
//				name=sc.next();
				System.out.println(" Details Entered sucessfully to Update.");
				//driver class loading
				Class.forName("com.mysql.cj.jdbc.Driver");
				//connection object creation.
				String s1 ="jdbc:mysql://localhost:3306/pkEnterprise";
				String s2 ="root";
				String s3 = "prasadnaidu";
				 Connection con =DriverManager.getConnection(s1,s2,s3);
				 // using prepared Statement and object creation.
				 PreparedStatement ps= con.prepareStatement("delete from pkemp where sno=?;");
			//	ps.setString(1, name);
				ps.setInt(1,a);
//				 System.out.println(rs);
				 int row=ps.executeUpdate();
				 
				 
				 if(row>0) {
				 System.out.println("updatation done.");
				 }
				 else
				 {
					 System.out.println("nothing");
				 }
				 ResultSet rs=ps.executeQuery("Select * from pkemp;");

				 while(rs.next())
				 {
					 
					 System.out.println(rs.getInt(1)+" "+rs.getString(2));
				 }
				
	}

}
