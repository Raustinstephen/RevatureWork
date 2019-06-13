package com.revature.banking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.SQLException;

import com.revature.daoimpl.UserDaoImpl;

class UserDaoImplTest {

	@Test
	void checkUserTest() {
		UserDaoImpl udi = new UserDaoImpl();
		
		try {
			//Admin should exist in the database, if nothing else
			assertEquals(true,udi.checkUser("Admin"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void findUserIDTest() {
		UserDaoImpl udi = new UserDaoImpl();
		try {
			int userIDTest = udi.findUserID("Admin");
			//Admin's USER_ID is the first, 10000
			assertEquals(10000,userIDTest);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
