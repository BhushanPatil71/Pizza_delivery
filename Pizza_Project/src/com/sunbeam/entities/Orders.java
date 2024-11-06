package com.sunbeam.entities;

public class Orders {
	@Override
	public String toString() {
		return "Orders [Id=" + Id + ", customerId=" + customerId + ", orderTime=" + orderTime + ", status=" + status
				+ "]";
	}

	int Id, customerId;
	String orderTime, status;
	
	public Orders(int id, int customerId, String orderTime, String status) {
		super();
		Id = id;
		this.customerId = customerId;
		this.orderTime = orderTime;
		this.status = status;
	}
	
}
