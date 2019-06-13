package com.revature.banking;

import java.util.Scanner;

import com.revature.unsused.EmployeeAccess;

public abstract class UserDashboard{
	//Abstract class. userType and userID are obtained from earlier, and checked for this switch statement
	public static void dash(int userType, int userID) {
		switch(userType) {
		
		case 1:
			//if usertype is one, they're a customer and go to the customer access dashboard
			CustomerAccess custA = new CustomerAccess();
			custA.custDash(userID);
			break;
		case 2:
			//employee isn't implemented in this version, but this is kept for future expansion
			EmployeeAccess empA = new EmployeeAccess();
			empA.employeeDash(userID);
			break;
		case 3:
			//all admins have usertype 3; in this version, there is only one
			AdminAccess admin = new AdminAccess();
			admin.adminDash(userID);
			break;
		case 4:
			//same with usertype 4
			System.out.println("This account has been cancelled!");
			break;
		
		
		}
	}
	
	
	
}
