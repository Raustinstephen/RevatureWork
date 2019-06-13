package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.UserInfo;
//UserDao interface
public interface UserDao {
	public abstract void createUser(String userName, int passEncrypt, String firstName, String lastName, String address, String city, String state, String phone, String email) throws SQLException;
	public abstract void logonAttempt(String response, int encryption) throws SQLException;
	public abstract void getUserInfo(int userID) throws SQLException;
	public abstract boolean checkUser(String response) throws SQLException;
	public abstract int findUserID(String username) throws SQLException;
	public abstract void updateUser(int userID, String username) throws SQLException;
	public abstract void deleteUser(String response) throws SQLException;
}