package com.revature.banking;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoimpl.UserDaoImpl;
import com.revature.util.ExceptionCatcher;

public class AdminAccess {
	//initializing IO
	static IO io = new IO();
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	
	
	
	//admin dashboard method
	public static void adminDash(int userID) {
		ExceptionCatcher ec = new ExceptionCatcher();
		CustomerAccess ca = new CustomerAccess();
		//while boolean login
		boolean loggedout = false;
		while (!loggedout) {
			System.out.println("What would you like to do?");
			System.out.println(	"1 - View User Information\n"
					+ 			"2 - View/Modify Account Information\n"
					+ 			"3 - Create New User\n"
					+ 			"4 - Delete User\n"
					+ 			"0 - Log Out\n"
					+ "=================================================================");
			Scanner input = new Scanner(System.in);
			String optionStr = input.nextLine();
			Integer option =ec.parseIntCheck(optionStr);
			//logout isn't part of the switch to fix a bug
			if (option==0) {
				loggedout=true;
				break;
			}
			switch (option) {
			case 1:
				//calls the user info bean
				System.out.println("Please input the username of the User you wish to view:");
				String username = input.nextLine();
				UserDaoImpl udi = new UserDaoImpl();
				int targetUserID;
				try {
					targetUserID = udi.findUserID(username);
					udi.getUserInfo(targetUserID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("=================================================================");
				break;
			case 2:
				//to modify an account, you have to input the username first
				System.out.println("Please enter the account number of the Account you wish to look up:");
				String targAccStr = input.nextLine();
				Integer accountID = ec.parseIntCheck(targAccStr);
					ca.accountActions(accountID, userID);
					logger.info(userID + " accessed " + accountID);
					
				break;
			case 3:
				//creates a new user
				NewUser nu = new NewUser();
				nu.createAccount();
				logger.info(userID + " created new User");
				break;
			case 4:
				//deletes a user (!!!)
				System.out.println("Please input the username of the User you wish to delete:");
				username = input.nextLine();
				udi = new UserDaoImpl();
				try {
					udi.deleteUser(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			
		}
		
	}
	
		
}
