package com.baizhi;

import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.service.IOrderService;
import com.baizhi.service.impl.IOrderServiceImpl;
import org.junit.Test;

public class TestOrder {
    private IOrderService orderService = new IOrderServiceImpl();
    @Test
    public void testInsertOrder(){
        Order order = new Order();

    }

    @Test
    public void testInsertItemOfOrder(){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderId(7);
        orderItem.setProductId(1);
        orderItem.setCount(1);
        orderItem.setAmount(20.0);
        orderService.insertItemOfOrder(orderItem);
    }

    @Test
    public void testselectAllByuserid(){
        orderService.selectOrderByUserId(1).forEach(System.out::println);

    }
}
