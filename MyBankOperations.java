package com.JDBCConnectivity;
import java.sql.SQLException;
import java.util.*;
public class MyBankOperations {

	public static void main(String[] args)throws ClassNotFoundException, SQLException {
		System.out.println("---------------WELCOME TO THE PKBANK---------------");
		Scanner sc= new Scanner(System.in);
		System.out.println("REGISTER                                     LOGIN");
		System.out.print("Enter the option(REGISTER/LOGIN):");
		String relog=sc.next();
		if(relog.equalsIgnoreCase("login"))
			{
			LoginMethods lm= new LoginMethods();
			lm.login();
				}
		else
		{
			RegisterClass rc= new RegisterClass();
			rc.register();
			
		}
	}

}
