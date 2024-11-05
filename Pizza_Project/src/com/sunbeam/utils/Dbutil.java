package com.sunbeam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbutil {
	private static final String URL = "jdbc:mysql://localhost:3306/sunbeam_hackathon";
	private static final String USERNAME = "D3_87180_Swami";
	private static final String PASSWORD = "manager";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}
