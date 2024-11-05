package com.sunbeam.tester;

import com.sunbeam.dao.LoginDao;
import com.sunbeam.entities.Customer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.sunbeam.dao.LoginDao;
import com.sunbeam.utils.Dbutil;

public class application {
	public static void signIn(Scanner sc) throws Exception {
		try (LoginDao c1 = new LoginDao()) {
			System.out.println("Enter email: ");
			String email = sc.next();
			System.out.println("Enter password: ");
			String password = sc.next();
			c1.signIn(email, password);
		}
	}
	public static void signUp(Scanner sc) {
		Customer c=new Customer();
		c.acceptCustomer(sc);
	}

	static void topMenu(Scanner sc) throws Exception {
		int choice;

		do {
			System.out.println("0. Exit");
			System.out.println("1. Sign In");
			System.out.println("2. Sign Up");
			System.out.println("Enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				signIn(sc);
				break;
			case 2:
				signUp(sc);
				break;
			default:
				break;
			}

		} while (choice != 0);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		try {
			topMenu(sc);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
