package com.revature.banking;

import java.sql.SQLException;
import java.util.Scanner;

import com.revature.daoimpl.UserDaoImpl;

public class App 
{
	//initializing the input/output Class
	static IO io = new IO();
	
	//Such a beautifully simple main makes me happy :D
    public static void main( String[] args )
    {
    	startup();
    }
    
    
    static void startup (){
    	//initializing a boolean to maintain the login screen

		System.out.println( "=================================================================\r\n" + 
							"                                                                 \r\n" + 
							" UUUUUUUU     UUUUUUUU        CCCCCCCCCCCCCFFFFFFFFFFFFFFFFFFFFFF\r\n" + 
							" U::::::U     U::::::U     CCC::::::::::::CF::::::::::::::::::::F\r\n" + 
							" U::::::U     U::::::U   CC:::::::::::::::CF::::::::::::::::::::F\r\n" + 
							" UU:::::U     U:::::UU  C:::::CCCCCCCC::::CFF::::::FFFFFFFFF::::F\r\n" + 
							"  U:::::U     U:::::U  C:::::C       CCCCCC  F:::::F       FFFFFF\r\n" + 
							"  U:::::D     D:::::U C:::::C                F:::::F             \r\n" + 
							"  U:::::D     D:::::U C:::::C                F::::::FFFFFFFFFF   \r\n" + 
							"  U:::::D     D:::::U C:::::C                F:::::::::::::::F   \r\n" + 
							"  U:::::D     D:::::U C:::::C                F:::::::::::::::F   \r\n" + 
							"  U:::::D     D:::::U C:::::C                F::::::FFFFFFFFFF   \r\n" + 
							"  U:::::D     D:::::U C:::::C                F:::::F             \r\n" + 
							"  U::::::U   U::::::U  C:::::C       CCCCCC  F:::::F             \r\n" + 
							"  U:::::::UUU:::::::U   C:::::CCCCCCCC::::CFF:::::::FF           \r\n" + 
							"   UU:::::::::::::UU     CC:::::::::::::::CF::::::::FF           \r\n" + 
							"     UU:::::::::UU         CCC::::::::::::CF::::::::FF           \r\n" + 
							"       UUUUUUUUU              CCCCCCCCCCCCCFFFFFFFFFFF           ");
    	boolean on = true;
    	while (on) {
        System.out.println(	   "=================================================================\n" 
        		+			   "=========Thank you for choosing Union Central Financial =========\n"
        		+ 			   "=Type \"new\" to create a new account, or enter your username here=\n"
        		+ 			   "=================================================================");
        			//having the user input username, or create a new user, from this screen
        			//saves us from having an extra screen
        			Scanner input = new Scanner(System.in);
        			String response = input.nextLine();
    
    //since this app is intended to be running indefinitely, the option to terminate it is hidden
    if (response.equals("off")) {
    	System.out.println("Program shutting down...");
    	on = false;
    }
    //creating a new account from this screen; constructs the newCustomer Class
    else if (response.equals("new")) {
    	NewUser nuser = new NewUser();
    	nuser.createAccount();
    }
    else {
    	//if not a new user, we construct the LogonAttempt Class, importing the 'response' input variable
    	System.out.println("===================Please enter your Password:===================");
		input = new Scanner(System.in);
		String passAttempt = input.nextLine();
		int passint = passAttempt.hashCode();
		int encryption = (passint*500003477)%1009747;
		
    	UserDaoImpl udi = new UserDaoImpl();
    	try {
			udi.logonAttempt(response, encryption);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	
    }
}
    }
}