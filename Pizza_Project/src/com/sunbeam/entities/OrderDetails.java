package com.sunbeam.entities;

public class OrderDetails {
	int Id, orderId, priceId;

	public OrderDetails(int id, int orderId, int priceId) {
		super();
		Id = id;
		this.orderId = orderId;
		this.priceId = priceId;
	}

	@Override
	public String toString() {
		return "OrderDetails [Id=" + Id + ", orderId=" + orderId + ", priceId=" + priceId + "]";
	}

}
