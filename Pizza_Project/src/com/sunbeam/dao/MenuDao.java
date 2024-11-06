package com.sunbeam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.sunbeam.entities.Employee;
import com.sunbeam.entities.Item;
import com.sunbeam.entities.ItemPrice;
import com.sunbeam.utils.Dbutil;

public class MenuDao implements AutoCloseable {
	Connection connection;

	public MenuDao() throws SQLException {
		connection = Dbutil.getConnection();
	}

	public void showVeg() throws SQLException {
		List<Item> itemList = new ArrayList<Item>();
		String sql = "SELECT * FROM PIZZA_ITEMS WHERE TYPE='Veg';";

		try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
			ResultSet rs = selectStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String category = rs.getString(4);
				String description = rs.getString(5);
				Item i = new Item(id, name, type, category, description);
				itemList.add(i);
			}
		}

		for (Item element : itemList) {
			System.out.println(element.toString());
		}

	}

	public void showNonVeg() throws SQLException {
		List<Item> itemList = new ArrayList<Item>();
		String sql = "SELECT * FROM PIZZA_ITEMS WHERE TYPE='NonVeg';";

		try (PreparedStatement selectStmt = connection.prepareStatement(sql)) {
			ResultSet rs = selectStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String type = rs.getString(3);
				String category = rs.getString(4);
				String description = rs.getString(5);
				Item i = new Item(id, name, type, category, description);
				itemList.add(i);
			}
		}

		for (Item element : itemList) {
			System.out.println(element.toString());
		}

	}

	public void showSize(int value) throws SQLException {
		List<ItemPrice> itemList = new ArrayList<ItemPrice>();
		String sql = "select * from pizza_pricing  where itemid = ? ;";
		try (PreparedStatement showStmt = connection.prepareStatement(sql)) {
			showStmt.setInt(1, value);
			ResultSet rs = showStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt(1);
				int itemId = rs.getInt(2);
				String size = rs.getString(3);
				double price = rs.getDouble(4);

				ItemPrice i = new ItemPrice(id, itemId, size, price);
				itemList.add(i);

			}
		}
		for (ItemPrice element : itemList) {
			System.out.println(element.toString());
		}

	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub

	}
}