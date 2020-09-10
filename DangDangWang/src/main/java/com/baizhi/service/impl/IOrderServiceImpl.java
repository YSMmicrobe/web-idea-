package com.baizhi.service.impl;

import com.baizhi.dao.IOrderDao;
import com.baizhi.entity.Order;
import com.baizhi.entity.OrderItem;
import com.baizhi.service.IOrderService;
import com.baizhi.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class IOrderServiceImpl implements IOrderService {

    @Override
    public void insertOrder(Order order) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IOrderDao orderDao = session.getMapper(IOrderDao.class);
            orderDao.insertOrder(order);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Override
    public void insertItemOfOrder(OrderItem orderItem) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IOrderDao orderDao = session.getMapper(IOrderDao.class);
            orderDao.insertItemOfOrder(orderItem);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }

    @Override
    public List<Order> selectOrderByUserId(int user_id) {
        SqlSession session = null;
        List<Order> orders = null;
        try {
            session = MybatisUtil.getSqlSession();
            IOrderDao orderDao = session.getMapper(IOrderDao.class);
            orders = orderDao.selectOrderByUserId(user_id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
        return orders;
    }

    @Override
    public void updateOrderStatus(int orderStatus) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getSqlSession();
            IOrderDao orderDao = session.getMapper(IOrderDao.class);
            orderDao.updateOrderStatus(orderStatus);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession(session);
        }
    }
}
