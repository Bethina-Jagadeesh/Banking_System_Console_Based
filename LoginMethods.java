package com.JDBCConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class LoginMethods extends MyBankOperations {
	public static void login() throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int i = 1;
		System.out.println();
		System.out.print("Enter your Account ID:");
		String ai=sc.next();
		System.out.println("");
		System.out.print("Enter your password:");
		String pw=sc.next();
	 Class.forName("com.mysql.cj.jdbc.Driver");
		//connection object creation.
		String s1 ="jdbc:mysql://localhost:3306/PKBANKS";
		String s2 ="root";
		String s3 = "prasadnaidu";
		 Connection con =DriverManager.getConnection(s1,s2,s3);
		 // using prepared Statement and object creation.
		 Statement s= con.createStatement();
		 ResultSet rs=s.executeQuery("Select * from register where ac_id='"+ai+"';");
		 String psw=null;
		 while(rs.next()) {
			psw= rs.getString("password");
		 }
		 if(pw.equals(psw))
		 {
			 
				
				while(true)
				{
					System.out.println("🙏🙏Here's that welcomes you to  Bank Application Operations🙏🙏");
					System.out.println("---------------------------------------------------------");
					System.out.println("1).Balance Enquery. ");
					System.out.println();
					System.out.println("2).Withdrwal");
					System.out.println();
					System.out.println("3).Deposite ");
					System.out.println();
					System.out.println("4).Change Password ");
					System.out.println();
					System.out.println("5).Exit ");
					System.out.println();
					
					int option;
					System.out.println("Enter option: ");
					option = sc.nextInt();
					BalanceEnquery be= new BalanceEnquery();
					Withdrwal wd= new Withdrwal();
					Deposite dp=new Deposite();
					ChangePassword cp= new ChangePassword();
							switch(option)
					{
						case 1:
							be.getBal(ai);
							break;
						case 2:
							wd.getMoney(ai);
							break;
						case 3:
							dp.putMoney(ai);
							break;
						case 4:
							cp.changepw(ai);
							break;
						case 5:
							System.exit(0);
							System.out.println("Thanks for visiting out Site 🙏.");
							
							
					}
				}
			
 
		 }
		 else
		 {
			 System.out.println("The Password you have Entered is Wrong.");
		 }
	}
}
