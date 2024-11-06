package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.entities.Customer;
import com.sunbeam.tester.application;
import com.sunbeam.utils.Dbutil;

public class LoginDao implements AutoCloseable {
	Connection connection;
	static String ref;

	public LoginDao() throws SQLException {
		connection = Dbutil.getConnection();
	}

	public void addCustomer(Customer c) throws SQLException {
		String sql = "INSERT INTO PIZZA_CUSTOMERS (NAME, PASSWORD, MOBILE, ADDRESS, EMAIL)" + " VALUES(?,?,?,?,?);";
		try (PreparedStatement insertStmt = connection.prepareStatement(sql)) {
			insertStmt.setString(1, c.getName());
			insertStmt.setString(2, c.getPassword());
			insertStmt.setString(3, c.getMobile());
			insertStmt.setString(4, c.getAddress());
			insertStmt.setString(5, c.getEmail());
			if (insertStmt.executeUpdate() > 0) {
				System.out.println("CUSTOMER REGISTERED SUCCESSFULLY");
			} else {
				System.out.println("REGISTRATION FAILED");
			}
		}
	}

	public void signIn(String email, String password) throws Exception {

		String sql = "SELECT * FROM PIZZA_CUSTOMERS WHERE EMAIL=?";
		try (PreparedStatement checkStmt = connection.prepareStatement(sql)) {
			checkStmt.setString(1, email);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString(3) + " " + password);
				if (rs.getString(3).equals(password)) {
					System.out.println("login succesfull");
					if (rs.getString(3).equals("admin")) {
						application.adminMenu();
					} else {
						application.customerMenu();;
					}
					ref = rs.getString(4);
				} else {
					System.out.println("Invalid password/ email");
				}
			} else {
				System.out.println("Invalid password/ email");
			}
		}
	}

	public void fetchCustomer(String email) throws SQLException {

		String sql = "SELECT * FROM PIZZA_CUSTOMERS WHERE EMAIL=?";
		try (PreparedStatement checkStmt = connection.prepareStatement(sql)) {
			checkStmt.setString(1, email);
			ResultSet rs = checkStmt.executeQuery();
			if (rs.next()) {
				System.out.println("Customer details: ");
				Customer c = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6));
				System.out.println(c.toString());
			} else {
				System.out.println("invalid email");
			}
		}

	}
	
	public void signOut() throws Exception {
		Scanner sc=new Scanner(System.in);
		ref=null;
		application.topMenu(sc);
	}

	@Override
	public void close() throws Exception {

	}
}
