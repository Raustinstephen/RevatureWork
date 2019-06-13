package com.revature.unsused;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.banking.IO;
import com.revature.banking.IO.Fixer;

public class EmployeeAccess {
	//initializing IO
	private static Logger logger = LogManager.getLogger(EmployeeAccess.class);
	static IO io = new IO();
	static String userString = io.readInputStreamContents("Users.txt");
	static String empString = io.readInputStreamContents("Users.txt");
	static String adminString = io.readInputStreamContents("Users.txt");
	static String[] userList = userString.split(System.getProperty("line.separator"));
	static int userLength = userList.length;
	
	public static void employeeDash(int userID) {
		String custString = io.readInputStreamContents("Customers.txt");
		String[] custList = custString.split(System.getProperty("line.separator"));
		
		//fixer method
		String [] testList = Fixer.fixingList(custList);
		custList = testList;
		
		//initializing the applicant list
		String appString = io.readInputStreamContents("Applicants.txt");
		String[] appList = appString.split(System.getProperty("line.separator"));
		
		testList = Fixer.fixingList(appList);
		appList = testList;
		//..and fixing it
		testList = Fixer.fixingList(userList);
		userList = testList;
		int custlength = custList.length;
		int appLength = appList.length;
		//boolean while loop
		boolean loggedout = false;
		while (!loggedout) {
			//all log out/go back buttons are 0, to allow the user to memorize the location
			System.out.println("What would you like to do?");
			System.out.println(	"1 - View Account Information\n"
					+ 			"2 - Approve/Deny Applications\n"
					+ 			"0 - Log Out\n"
					+ "=================================================================");
			Scanner input = new Scanner(System.in);
			String optionStr = input.nextLine();
			int option = Integer.parseInt(optionStr);
			switch (option) {
			case 1:
				//simple account lookup
				System.out.println("Please enter the username of the Account you wish to look up:");
				String userLookup = input.nextLine();
			for (int j = 1; j < userLength; j++) {
				String[] userSplit = userList[j].split(":");
				if ((userLookup.equals(userSplit[1]))) {
					int userTarget = Integer.parseInt(userSplit[0]);
					for (int k = 1; k < custlength; k++) {
						String[] custSplit = custList[k].split(":");
						int checkCust = Integer.parseInt(custSplit[0]);
						if (checkCust == userTarget) {
							//once found, have two options as an employee
							System.out.println("What would you like to look up?\n"
									+ "1 - Account Balance\n"
									+ "2 - Account Information\n"
									+ "0 - Go Back");
							input = new Scanner(System.in);
							optionStr = input.nextLine();
							option = Integer.parseInt(optionStr);
							switch(option) {
							case 1:
								//the easy one, just printing customer info
								System.out.println("User " + userLookup + " has an account balance of $" + custSplit[1]);
								break;
							case 2:
								//creating a customer 
//								Customer cust = new Customer();
//								cust.setAccountBalance(Double.parseDouble(custSplit[1]));
//								cust.setFullName(custSplit[3]);
//								boolean joint = Boolean.parseBoolean(custSplit[2]);
//								cust.setJoint(joint);
//								int custID = Integer.parseInt(custSplit[0]);
//								cust.setID(custID);
//								cust.setUsername(userSplit[1]);
//								System.out.println(cust.toString());
								break;
							case 3:
								//just logout
								loggedout = true;
								break;
							}
							
							
						}
					}
				}
				
				
			}
				break;
			case 2:
				boolean success = false;
				while (!success) {
					//employees can also see the applicants
					System.out.println("What would you like to do?\n"
							+ "1 - View Applicant List\n"
							+ "2 - Approve/Deny Individual Applicants\n"
							+ "3 - Approve/Deny Applicants Sequentially\n"
							+ "0 - Go Back");
					String approveDenyChoice = input.nextLine();
					switch(Integer.parseInt(approveDenyChoice)) {
						case 1:
							//here is the applicant list; pretty straight-forward
							System.out.println("=========================Applicant List:=========================");
							for (int j = 1; j < appLength; j++) {
								String[] applicantSplit = appList[j].split(":");
								
								if (!(Boolean.parseBoolean(applicantSplit[5]))) {
									if (!(Boolean.parseBoolean(applicantSplit[4]))) {
								boolean jointApp = Boolean.parseBoolean(applicantSplit[2]);
								//to change up the wording depending on joint or not
								if (jointApp) {
									System.out.println("Applicant: " + applicantSplit[7] + ", a joint account, initial deposit: " + applicantSplit[6] + ", userID: " + applicantSplit[0]);
								}
								else {
									System.out.println("Applicant: " + applicantSplit[7] + ", initial deposit: " + 
											applicantSplit[6] + ", userID: " + applicantSplit[0]);
									}
								}
								}
							}
							
							System.out.println("=================================================================");
							break;
						case 2:
							//the search capability for applicants
							System.out.println("=================================================================");
							System.out.println("Input the Applicant ID of the Applicant you wish to view:");
							String appIDcase2 = input.nextLine();
							//initializing the method
							appReviewSearch(appIDcase2, appLength, appList, userID);
							break;
						case 3:
							//initializing the method
							appReviewSequential(appLength, appList, userID);
							break;
						case 0: 
							//logging out
							success = true;
							break;
					}
				}
				break;
			case 0:
				//logging out again
				loggedout=true;
				break;
			}
		}
		
	}
	//applicant search method
	static void appReviewSearch(String appIDcase2, int appLength, String[] appList, int userID) {
		Scanner input = new Scanner(System.in);
		int appIDcase2Int = Integer.parseInt(appIDcase2);
		for (int j = 1; j < appLength; j++) {
			String[] applicantSplit = appList[j].split(":");
			//normal search technique
			if (appIDcase2Int == Integer.parseInt(applicantSplit[0])) {
				boolean jointApp = Boolean.parseBoolean(applicantSplit[2]);
				if (!(Boolean.parseBoolean(applicantSplit[5]))) {
					if (!(Boolean.parseBoolean(applicantSplit[4]))) {
				if (jointApp) {
					System.out.println("=================================================================");
					System.out.println("Applicant: " + applicantSplit[7] + ", a joint account, initial deposit: " + applicantSplit[6] + ", userID: " + applicantSplit[0]);
				}
				else {
					System.out.println("=================================================================");
					System.out.println("Applicant: " + applicantSplit[7] + ", initial deposit: " + 
							applicantSplit[6] + ", userID: " + applicantSplit[0]);
				}
					}
					//if searching for a previously-approved applicant
					else {
						System.out.println("This Application has already been approved!");
						System.out.println("=================================================================");
						break;
					}
				}
				//if searching for a previously-denied applicant
				else {
					System.out.println("This Application has already been denied!");
					System.out.println("=================================================================");
					break;
				}
				//simply approve/deny controls
				System.out.println("To approve this Applicant, input \"approve\"; to deny, input \"deny\".");
				String approveDeny = input.nextLine();
				if (approveDeny.equals("approve")) {
					boolean approved = true;
					System.out.println("The application from " + applicantSplit[7] + " has been approved!");
					System.out.println("=================================================================");
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "true" + ":" + applicantSplit[5] + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					//when approved, their applicants file is overwritten while their name is appended to the bottom of users AND customers
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[1] + ":" + "1" + ":" + applicantSplit[3], "Users.txt");
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[6] + ":" + applicantSplit[2] + ":" + applicantSplit[7], "Customers.txt");
				}
				else if (approveDeny.equals("deny")) {
					//if denied, they just get their applicant status changed to match
					boolean denied = true;
					System.out.println("The application from " + applicantSplit[7] + " has been denied!");
					System.out.println("=================================================================");
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "false" + ":" + "true" + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
				}
			}
		}
	}
	
		//sequential viewing of applicant list
		static void appReviewSequential(int appLength, String[] appList, int userID){
			Scanner input = new Scanner(System.in);
			//looking through each applicant, one by one
		for (int j = 1; j < appLength; j++) {
			String[] applicantSplit = appList[j].split(":");
			boolean jointApp = Boolean.parseBoolean(applicantSplit[2]);
			if (!(Boolean.parseBoolean(applicantSplit[5]))) {
				if (!(Boolean.parseBoolean(applicantSplit[4]))) {
					//if it's a joint or not
			if (jointApp) {
				System.out.println("=================================================================");
				System.out.println("Applicant: " + applicantSplit[7] + 
						", a joint account, initial deposit: " + applicantSplit[6] + ", userID: " + applicantSplit[0]);
				//give employee ability to make choice on approve/deny
				System.out.println("To approve this Applicant, input \"approve\"; to deny, input \"deny\"; \n"
						+ "To skip, press any other key");
				String approveDeny = input.nextLine();
				if (approveDeny.equals("approve")) {
					boolean approved = true;
					System.out.println("The application from " + applicantSplit[7] + " has been approved!");
					System.out.println("=================================================================");
					
					logger.info(applicantSplit[0] + "'s application approved by USER " + userID);
					
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "true" + ":" + applicantSplit[5] + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					//overwriting
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[1] + ":" + "1" + ":" + applicantSplit[3], "Users.txt");
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[6] + ":" + applicantSplit[2] + ":" + applicantSplit[7], "Customers.txt");
				}
				else if (approveDeny.equals("deny")) {
					boolean denied = true;
					System.out.println("The application from " + applicantSplit[7] + " has been denied!");
					System.out.println("=================================================================");
					
					logger.info(applicantSplit[0] + "'s application denied by USER " + userID);
					
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "false" + ":" + "true" + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
				}
				else {
					continue;
				}
				
			}
			else {
				//same as above but without joint accounts
				System.out.println("=================================================================");
				System.out.println("Applicant: " + applicantSplit[7] + ", initial deposit: " + 
						applicantSplit[6] + ", userID: " + applicantSplit[0]);
				
				System.out.println("To approve this Applicant, input \"approve\"; to deny, input \"deny\"; to skip, input \"skip\"");
				String approveDeny = input.nextLine();
				if (approveDeny.equals("approve")) {
					boolean approved = true;
					System.out.println("The application from " + applicantSplit[7] + " has been approved!");
					System.out.println("=================================================================");
					
					logger.info(applicantSplit[0] + "'s application approved by USER " + userID);
					//overwriting both user and customer as explained above
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "true" + ":" + applicantSplit[5] + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[1] + ":" + "1" + ":" + applicantSplit[3], "Users.txt");
					io.writeOutputStreamContents(System.getProperty("line.separator") + 
							applicantSplit[0] + ":" + applicantSplit[6] + ":" + applicantSplit[2] + ":" + applicantSplit[7], "Customers.txt");
				}
				else if (approveDeny.equals("deny")) {
					boolean denied = true;
					System.out.println("The application from " + applicantSplit[7] + " has been denied!");
					System.out.println("=================================================================");
					
					logger.info(applicantSplit[0] + "'s application denied by USER " + userID);
					
					String applicant = applicantSplit[0] + ":" + applicantSplit[1] + ":" + applicantSplit[2] + 
							":" + applicantSplit[3] + ":" + "false" + ":" + "true" + ":" + 
							applicantSplit[6] + ":" + applicantSplit[7];
					IO.overwriter("Applicants.txt", applicant, appList[j],appLength);
				}
				else {
					continue;
				}
			}
				}
			}
		}
			
		}
}
