package com.baizhi.entity;

public class OrderItem {
	private int id;
	private int orderId;
	private int productId;
	private int count;
	private double amount;
	
	//多对一查询做准备
	private Book book;

	@Override
	public String toString() {
		return "OrderItem{" +
				"id=" + id +
				", orderId=" + orderId +
				", productId=" + productId +
				", count=" + count +
				", amount=" + amount +
				", book=" + book +
				'}';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
