package com.sunbeam.tester;

import com.sunbeam.dao.LoginDao;
import com.sunbeam.dao.MenuDao;
import com.sunbeam.dao.OrderDao;
import com.sunbeam.entities.Customer;
import com.sunbeam.entities.ItemPrice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

	public static void signUp(Scanner sc) throws Exception {
		Customer c = new Customer();
		c.acceptCustomer(sc);
		try (LoginDao c1 = new LoginDao()) {
			c1.addCustomer(c);
		}
	}

	public static void signOut() throws SQLException, Exception {
		try (LoginDao c1 = new LoginDao()) {
			c1.signOut();
		}
	}

	public static void showVeg(Scanner sc) throws Exception {
		try (MenuDao c1 = new MenuDao()) {
			c1.showVeg();
		}
	}

	public static void showNonVeg(Scanner sc) throws Exception {
		try (MenuDao c1 = new MenuDao()) {
			c1.showNonVeg();
		}
	}

	public static void showAvailableSizes(Scanner sc) throws Exception {
		System.out.println("Enter item id: ");
		int itemId = sc.nextInt();
		try (MenuDao c1 = new MenuDao()) {
			c1.showSize(itemId);
		}
	}

	public static void addToCart(Scanner sc , List<ItemPrice> cart) throws SQLException, Exception {
		try (OrderDao c1 = new OrderDao()) {
			System.out.println("Enter item price id: ");
			int priceId = sc.nextInt();
			c1.addToCart(priceId,cart);
		}
	}

	public static void showCart(List<ItemPrice> cart) throws SQLException, Exception {
//		System.out.println("called");
		try (OrderDao c1 = new OrderDao()) {
			c1.showCart(cart);
			
		}
	}

	public static void showAllOrders() throws Exception {
		try (OrderDao c1 = new OrderDao()) {
			c1.showAllOrders();
		}
	}

	public static void showOrderDetails(Scanner sc) throws Exception {
		try (OrderDao c1 = new OrderDao()) {
			System.out.println("Enter order id:");
			int id = sc.nextInt();
			c1.showOrderDetails(id);
		}
	}

	public static void topMenu(Scanner sc) throws Exception {
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

	public static void customerMenu() throws Exception {
		List<ItemPrice> cart = new ArrayList<ItemPrice>();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("Customer Menu : ");
			System.out.println("0. Exit ");
			System.out.println("1. Show Veg Items ");
			System.out.println("2. Show Non-Veg Items ");
			System.out.println("3. Show available sizes (for given Item id)");
			System.out.println("4. Add to cart (for given price id)");
			System.out.println("5. Show Cart (Pizzas with Size & Price Details)");
			System.out.println("6. Place Order (Save Order in Database for current customer)");
			System.out.println("7. Sign Out");

			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				showVeg(sc);
				break;
			case 2:
				showNonVeg(sc);
				break;
			case 3:
				showAvailableSizes(sc);
				break;
			case 4:
				addToCart(sc , cart);
				break;
			case 5:
				showCart(cart);
				break;
//			case 6:
//				placeOrder();
			case 7:
				signOut();
				break;
			default:
				break;
			}

		} while (choice != 0);

	}

	public static void adminMenu() throws Exception {
		int choice = 0;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("0. Exit");
			System.out.println("1. Show all orders");
			System.out.println("2. Show order details (for given order id show Pizza & Customer details)");
			System.out.println("3. Sign Out");
			System.out.println("Enter your choice");
			choice = sc.nextInt();

			switch (choice) {
			case 1:
				showAllOrders();
				break;
			case 2:
				showOrderDetails(sc);
			case 3:
				signOut();
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
