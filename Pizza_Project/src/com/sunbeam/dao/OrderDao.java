package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sunbeam.entities.ItemPrice;
import com.sunbeam.entities.OrderDetails;
import com.sunbeam.entities.Orders;
import com.sunbeam.utils.Dbutil;

public class OrderDao implements AutoCloseable {
	Connection connection;
	
	static String ref;

	public OrderDao() throws SQLException {
		connection = Dbutil.getConnection();
	}

	public void showAllOrders() throws SQLException {
		List<Orders> o = new ArrayList<>();
		String sql = "SELECT * FROM PIZZA_ORDERS";
		try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
			ResultSet rs = selectStmt.executeQuery();
			while (rs.next()) {
				o.add(new Orders(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4)));
			}
		}

		o.forEach(System.out::println);
	}

	public void showOrderDetails(int id) throws Exception {
		List<OrderDetails> o = new ArrayList<>();
		String sql = "SELECT * FROM PIZZA_ORDERDETAILS WHERE ORDERID=?;";
		try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
			selectStmt.setInt(1, id);
			ResultSet rs = selectStmt.executeQuery();
			while (rs.next()) {
				o.add(new OrderDetails(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
			}
		}
		o.forEach(System.out::println);
	}

	public void addToCart(int id, List<ItemPrice> cart ) throws SQLException {

		String sql = "select * from pizza_pricing where id = ? ;";

		try (PreparedStatement showStmt = connection.prepareStatement(sql)) {
			showStmt.setInt(1, id);
			ResultSet rs = showStmt.executeQuery();

			while (rs.next()) {
				int priceId = rs.getInt(1);
				int itemId = rs.getInt(2);
				String size = rs.getString(3);
				double price = rs.getDouble(4);

				cart.add(new ItemPrice(priceId, itemId, size, price));

			}
		}

		for (ItemPrice element : cart) {
			System.out.println(element.toString());
		}
		
	}

	public void showCart(List<ItemPrice> cart ) throws SQLException {
		cart.forEach(System.out::println);
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}
}
