package com.sunbeam.entities;

public class Item {
// Fields
	int ID;
	String name, type, category, description;

	public Item(int iD, String name, String type, String category, String description) {
		ID = iD;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Item [ID=" + ID + ", name=" + name + ", type=" + type + ", category=" + category + ", description="
				+ description + "]";
	}

}
