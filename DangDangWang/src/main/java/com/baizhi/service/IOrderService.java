package com.baizhi.service;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;

import java.util.List;

public interface IOrderService {
    void insertOrder(Order order);

    void insertItemOfOrder(OrderItem orderItem);

    List<Order> selectOrderByUserId(int user_id);

    void updateOrderStatus(int orderStatus);
}
