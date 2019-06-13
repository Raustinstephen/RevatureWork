package com.revature.banking;

import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daoimpl.UserDaoImpl;

public class NewUser {
	//new user class
	//initializing the logger. tried to have a log of all important transactions
	private static Logger logger = LogManager.getLogger(AdminAccess.class);
	static Scanner input = new Scanner(System.in);
	static void createAccount() {
		boolean success = false;
		while (!success) {
			//allowing the user the ability to back out without going through account creation
	System.out.println("Please choose a Username, or type \"esc\" to go back.");
	String nameAttempt = input.nextLine();
	UserDaoImpl udi = new UserDaoImpl();
	
	try {
		//the aforementioned escape rope
		if (nameAttempt.equals("esc")) {
			break;
		}
		//calling checkUser to see if the name already exists
		else if(udi.checkUser(nameAttempt)) {
			System.out.println("Username already exists. ");
			System.out.println("=================================================================");
			
		}
		//preventing too short of names, and myself from flubbing the demo again by 
		//making a new account with username ""
		else if (nameAttempt.length()<6){
			System.out.println("Please choose a username with 6 or more characters");
			System.out.println("=================================================================");
			
		}
		else {
			//calling passCheck method
			String password = passCheck();
			int passint = password.hashCode();
			//encrypting it with a very simple encryption
			int encryption = (passint*500003477)%1009747;
			//allowing the user to fill in their info
			System.out.println("First Name:");
			String firstName = input.nextLine();
			System.out.println("Last Name:");
			String lastName = input.nextLine();
			System.out.println("Street Address:");
			String address = input.nextLine();
			System.out.println("City:");
			String city = input.nextLine();
			System.out.println("State:");
			String state = input.nextLine();
			System.out.println("Phone Number:");
			String phone = input.nextLine();
			System.out.println("Email:");
			String email = input.nextLine();
			//using the info in the createUser method, which calls a stored procedure in SQL
			udi.createUser(nameAttempt, encryption, firstName, lastName, address, city, state, phone, email);
			logger.info("User " + nameAttempt + " created.");
			System.out.println("Thank you for registering. \n"
	    			+ "=================================================================\n"
	    			+ "Have a Great Day!");
			success = true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		}
	}
	//aforementioned method meant to verify password integrity
	public static String passCheck() {
		boolean passValid = false;
		while (!passValid) {
			System.out.println("Please choose a Password at least 6 characters:");
			String password = input.nextLine();
			
			System.out.println("Please re-enter your Password choice:");
			String passwordCheck = input.nextLine();
			//ensuring the passwords match
			if (!(password.equals(passwordCheck))) {
				System.out.println("Your Passwords do not match, please try again.");
			}
			//ensuring a long enough password
			else if (password.length()<6) {
				System.out.println("Your Password is not long enough, please try again.");
			}
			
			else {
				//only way out is to return the password
				return password;
			}
			}
		//this is here because a String method requires a return, but this should never be returned
		return null;
	}
}
