package com.baizhi.dao;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;

import java.util.List;

public interface IOrderDao {

    void insertOrder(Order order);

    void insertItemOfOrder(OrderItem orderItem);

    List<Order> selectOrderByUserId(int user_id);

    void updateOrderStatus(int orderStatus);
}
