package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Account;
//AccountDao interface
public interface AccountDao {
	public abstract List<Integer> pullAccountID(int userID) throws SQLException;
	public abstract Double pullAccountBalance(int userID) throws SQLException;
	public abstract void withdrawFunds(int accID, Double withdraw, int userID) throws SQLException;
	public abstract void depositFunds(int accID, Double deposit, int userID) throws SQLException;
	public abstract void transferFunds(int accID, int targAccID,Double transfer, int userID) throws SQLException;
	public abstract void createAccount(Double startBal, int userID) throws SQLException;
	public abstract void deleteAccount(int accID, int userID) throws SQLException;
	public List<Account> getAccountList(int userID) throws SQLException;
}
