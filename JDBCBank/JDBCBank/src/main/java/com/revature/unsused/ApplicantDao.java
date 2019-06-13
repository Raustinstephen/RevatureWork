package com.revature.unsused;

import java.sql.SQLException;

public interface ApplicantDao {
	public abstract void applyCheckUser(String response) throws SQLException;
	public abstract void createApplicant(String userName, int passEncrypt) throws SQLException;
}
