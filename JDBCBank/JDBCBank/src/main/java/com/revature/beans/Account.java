package com.revature.beans;
//account bean
public class Account {
	private int accountID;
	private double accountBalance;
	public int getAccountID() {
		return accountID;
	}
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Account(int accountID, double accountBalance) {
		super();
		this.accountID = accountID;
		this.accountBalance = accountBalance;
	}
	@Override
	public String toString() {
		return "================================================================\n"
				+ "Account " + accountID + 
				"\nCurrent Balance: " + accountBalance +
				"\n================================================================";
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
