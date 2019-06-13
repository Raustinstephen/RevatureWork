package com.revature.unsused;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.IO;
import com.revature.banking.IO.Fixer;
public class newCustomer {
	//doing a lot of reading/writing, so instantiating the 'Applicants' and 'Users' files, and separating them into their individual rows for evaluation
	static IO io = new IO();
	private static Logger logger = LogManager.getLogger(newCustomer.class);
	static String appString = io.readInputStreamContents("Applicants.txt");
	static String[] appList = appString.split(System.getProperty("line.separator"));
	//getting the number of lines to bound the search loops
	static int appNum = appList.length;
	static String userString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static int userNum = userList.length;
	
	
	
	static void usernameChoose(){
		//algorithm to ignore empty lines in input file
		String[] testList = Fixer.fixingList(userList);
		userList = testList;
		Scanner input = new Scanner(System.in);
		
		//boolean to keep the while loop open when attempting to create a username
		boolean validName = false;
		while (!validName) {
		System.out.println("Please choose a Username");
		String appAttempt = input.nextLine();
		
		//searching the Users and Applicants file for the username to avoid duplicates
		for (int i = 0; i < userNum; i++) {
			String[] userSplit = userList[i].split(":");
			for (int j = 0; j < appNum; j++) {
			String[] appSplit = appList[j].split(":");
			//if the username appears in the Users file
			if (appAttempt.equals(userSplit[1])) {
				System.out.println("Username already taken.\nPlease choose a different Username");
				appAttempt = input.nextLine();
			}
			//if the username appears in the Applicants file
			else if (appAttempt.equals(appSplit[1])) {
				System.out.println("Username already taken.\nPlease choose a different Username");
				appAttempt = input.nextLine();
			}
		}
		
		//setting validname to true to end the loop if the above two if statements don't happen
		validName = true;
		}
		//same while loop being controlled by a boolean
		boolean passLengthOkay = false;
		while (!passLengthOkay) {
		//choosing a password. Only requirement is 6-10 characters, but there could be more to improve security
		System.out.println("Please choose a Password with 6 to 10 characters:");
		String password = input.nextLine();
		//again, seeing if the password is too long or short
			if (password.length()>10) {
				System.out.println("This password is too long; try again.");
			}
			else if (password.length()<6) {
				System.out.println("This password is too short; try again");
			}
			else {
				//for just a touch of security, the hashcode of the password is multiplied by a VERY big prime number, then the product
				//is divided by another large prime number, with the remainder being stored in the database.
				int passint = password.hashCode();
				int encryption = (passint*500003477)%1009747;
				//standard things banks ask when opening an account
				System.out.println("UCF requires an initial deposit of $25; how much would you like to deposit?");
				String initDepo = input.nextLine();
				int initDeposit = Integer.parseInt(initDepo);
				System.out.println("UCF requires you to provide your full first and last name:");
				String fullname = input.nextLine();
				//initialize the jointApply method, for applying for joint accounts
				boolean joint = jointApply();
				//all applicants are not approve AND not denied, shocking I know
				boolean approved = false;
				boolean denied = false;
				//to ensure each user has a unique ID, the lengths of both files are added together and used as the user ID
				int appID = appNum + userNum;
//				Applicants a = new Applicants(appID,appAttempt,joint, encryption,approved);
				//logging the creation of the new account
				logger.info("Application for account made by " + fullname);
				//adding the new applicant to the end of the applicants text file
				io.writeOutputStreamContents(System.getProperty("line.separator") + 
						appID + ":" + appAttempt + ":" + joint + ":" + encryption+ ":" + 
						approved + ":" + denied + ":" + initDeposit + ":" + fullname, "Applicants.txt");
				//getting out of the while loop
				passLengthOkay=true;
			}
		}

		}
		
	}
	
	//jointApply method
	public static boolean jointApply() {
		//initialize it as false
		boolean joint = false;
		System.out.println("Would you like to apply for a joint bank account? (Y or N)");
		Scanner input = new Scanner(System.in);
		String response = input.nextLine();
		//if they say Y, it becomes true; otherwise, defaults to false
		if (response.equals("Y")) {
			joint = true;
		}
		//return the boolean value
		return joint;
	}
}
