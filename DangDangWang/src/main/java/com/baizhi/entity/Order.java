package com.baizhi.entity;

import java.util.Date;
import java.util.List;

public class Order {
	private int id;
	private double goodPrice;
	private Date orderTime;
	private int orderState;
	private int addrId;
	private int userId;
	private List<OrderItem> orderItemList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getGoodPrice() {
		return goodPrice;
	}
	public void setGoodPrice(double goodPrice) {
		this.goodPrice = goodPrice;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public int getAddrId() {
		return addrId;
	}
	public void setAddrId(int addrId) {
		this.addrId = addrId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<OrderItem> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}
	public Order(int id, double goodPrice, Date orderTime, int orderState, int addrId, int userId) {
		super();
		this.id = id;
		this.goodPrice = goodPrice;
		this.orderTime = orderTime;
		this.orderState = orderState;
		this.addrId = addrId;
		this.userId = userId;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", goodPrice=" + goodPrice + ", orderTime=" + orderTime + ", orderState="
				+ orderState + ", addrId=" + addrId + ", userId=" + userId + ", orderItemList=" + orderItemList + "]";
	}
	
}
