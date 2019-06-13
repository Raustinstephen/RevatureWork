package com.revature.banking;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.revature.daoimpl.AccountDaoImpl;

class AccountDaoImplTest {

	@Test
	void pullAccountIDTest() {
		AccountDaoImpl adi = new AccountDaoImpl();
		try {
			//Account 10003 has 2 accounts
			List<Integer> accIDTest = adi.pullAccountID(10003);
			int accSizeTest = accIDTest.size();
			assertEquals(accSizeTest,2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void pullAccountBalanceTest(){
		//assuming account 102 has $800.0
		AccountDaoImpl adi = new AccountDaoImpl();
		Double accBalTest;
		try {
			accBalTest = adi.pullAccountBalance(102);
			Double acc102Actual = 800.0;
			assertEquals(accBalTest,acc102Actual);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
	@Test
	void depositFundsTest() {
		//depositing $200.0 into account 103 using user 10000
		AccountDaoImpl adi = new AccountDaoImpl();
		try {
			Double acc103Before=adi.pullAccountBalance(103);
			Double acc103AfterTest=acc103Before+200.0;
			adi.depositFunds(103, 200.0, 10000);
			Double acc103After=adi.pullAccountBalance(103);
			assertEquals(acc103AfterTest,acc103After);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	void withdrawFundsTest() {
		//withdrawing $200.0 from account 103 using user 10000
		AccountDaoImpl adi = new AccountDaoImpl();
		try {
			Double acc103Before=adi.pullAccountBalance(103);
			Double acc103AfterTest=acc103Before-200.0;
			adi.withdrawFunds(103, 200.0, 10000);
			Double acc103After=adi.pullAccountBalance(103);
			assertEquals(acc103AfterTest,acc103After);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
