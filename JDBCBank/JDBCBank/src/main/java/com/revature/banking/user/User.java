package com.revature.banking.user;
//abstract user bean
abstract class User {
	private int ID;
	private static String username;
	private int userStatus;
	private int passEncrypt;
	
	@Override
	public String toString() {
		return "User [ID=" + ID + ", username=" + username + ", userStatus=" + userStatus + "]";
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
}