package com.JDBCConnectivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
public class RegisterClass extends MyBankOperations {
//
//	public static void main(String[] args) throws ClassNotFoundException, SQLException   {
		// TODO Auto-generated method stub
		public static void register() throws ClassNotFoundException, SQLException {
		Scanner sc= new Scanner(System.in);
		System.out.println("---------------Welcome to the register page👋---------------.");
		int amount=0;
		String name,ac_id,ph_no,passwd,loc,mail;
		System.out.print("Please Enter  The Name :");
		name=sc.nextLine();
		System.out.println("");
		System.out.print("Please Enter A Unique Account ID:");
		ac_id=sc.nextLine();
		System.out.println("");
		System.out.print("Please Enter Your Phone Number:");
		ph_no=sc.nextLine();
		System.out.println("");
		System.out.print("Please Enter Your EMAIL ID:");
		mail=sc.nextLine();
		System.out.println("");
		System.out.print("Enter The location:");
		loc=sc.nextLine();
		System.out.println("");
		System.out.print("Please Enter Your PASSWORD:");
		passwd=sc.nextLine();
		System.out.println("Please Remember your password.");
		System.out.println("");
		System.out.print("DO You Want To Deposite Some Amount On Your Account(YES/NO):");
		 String dopen=sc.next();
		 if(dopen.equalsIgnoreCase("no"))
		 {
			 System.out.println("Thanks For Registering In Our Bank.");
			 
		 }
		 else
		 {
			 System.out.println("please Enter Amount:");
				int intake =sc.nextInt();
				amount=amount+intake;
				System.out.println("The amount you deposited is :"+intake);
				System.out.println("The Total Amount On your Account Is :"+amount);
		 }
		 Class.forName("com.mysql.cj.jdbc.Driver");
			//connection object creation.
			String s1 ="jdbc:mysql://localhost:3306/PKBANKS";
			String s2 ="root";
			String s3 = "prasadnaidu";
			 Connection con =DriverManager.getConnection(s1,s2,s3);
			 // using prepared Statement and object creation.
			 PreparedStatement ps= con.prepareStatement("insert into register values(?,?,?,?,?,?,?);");
			ps.setString(1,name);
			ps.setString(2,ac_id);
			ps.setString(3,ph_no);
			ps.setString(4,mail);
			ps.setString(5,loc);
			ps.setString(6,passwd);
			ps.setInt(7,amount);
			 int row=ps.executeUpdate();
			 ResultSet rs=ps.executeQuery("Select * from register;");

		}


}
