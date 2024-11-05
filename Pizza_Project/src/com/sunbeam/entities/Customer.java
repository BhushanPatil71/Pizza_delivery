package com.sunbeam.entities;

import java.util.Scanner;

public class Customer {
	int ID;
	String name, password, mobile, address, email;

	public Customer(int ID, String name, String password, String mobile, String address, String email) {
		this.ID = ID;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}

	public Customer() {
		
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", name=" + name + ", password=" + password + ", mobile=" + mobile + ", address="
				+ address + ", email=" + email + "]";
	}
	
	public void acceptCustomer(Scanner sc) {
		System.out.println("Enter name: ");
		name=sc.next();
		System.out.println("Enter password: ");
		password=sc.next();
		System.out.println("Enter mo no: ");
		mobile=sc.next();
		System.out.println("Enter email: ");
		email=sc.next();
		System.out.println("Enter address: ");
		address=sc.next();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
