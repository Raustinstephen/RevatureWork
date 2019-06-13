package com.revature.unsused;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.IO;
import com.revature.banking.UserDashboard;
import com.revature.banking.IO.Fixer;

public class LogonAttempt {
	//initializing the IO for logging in
	static IO io = new IO();
	//initializing the logger
	private static Logger logger = LogManager.getLogger(LogonAttempt.class);
	
	
	static void login(String response){
		//reading the Users text file
		String userString = io.readInputStreamContents("Users.txt");
		String[] userList = userString.split(System.getProperty("line.separator"));
		int userLength = userList.length;
		//initializing the Fixer class, and the fixingList method, in IO.
		String[] testList = Fixer.fixingList(userList);
		userList = testList;
		//initializing boolean for while loop
			boolean success = false;
		
		while (!success) {
			
		String userTest = response;
		//esc leaves the loop in case somebody is stuck
		if (userTest.equals("esc")) {
			break;
		}
		//searching for username
		for (int i = 1; i < userLength; i++) {
			String[] userSplit = userList[i].split(":");
			if (!(userTest.equals(userSplit[1]))) {
				continue;
			}
			else 
				{
				//again, initializing a while loop
				boolean passSuccess = false;
				while (!passSuccess) {
					//having them enter password
				System.out.println("===================Please enter your Password:===================");
				Scanner input = new Scanner(System.in);
				String passAttempt = input.nextLine();
				//chance to go back/exit loop
				if (passAttempt.equals("esc")) {
					passSuccess=true;
					break;
				}
				//encrypting the password to check with the encrypted password on the file
				int passint = passAttempt.hashCode();
				int encryption = (passint*500003477)%1009747;
				int checkr = Integer.parseInt(userSplit[3]);
				//if it matches, we run the userDashboard dash method
				if (checkr == encryption) {
					logger.info(userSplit[1]);
					System.out.println("Welcome " + userSplit[1]);
//					UserDashboard init = new UserDashboard();
					int accessType = Integer.parseInt(userSplit[2]);
					int userID = Integer.parseInt(userSplit[0]);
					
					UserDashboard.dash(accessType, userID);
					//setting all values to true to ensure when logged out the program returns to the front page
					success = true;
					passSuccess = true;
				}
				}
			}
		}
		
		}
		
	}
	
}
