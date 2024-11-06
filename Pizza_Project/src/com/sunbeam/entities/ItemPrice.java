package com.sunbeam.entities;

public class ItemPrice {
// fields

	int id, itemId;
	String size;
	double price;

	public ItemPrice(int id, int itemId, String size, double price) {
		super();
		this.id = id;
		this.itemId = itemId;
		this.size = size;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ItemPrice [id=" + id + ", itemId=" + itemId + ", size=" + size + ", price=" + price + "]";
	}

}