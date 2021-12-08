package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.dao.impl.OrdersDaoImpl;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    @Override
    public Orders getOrdersByIdService(Integer orderId) {
        Orders orders = new Orders();
        OrdersDao ordersDao = new OrdersDaoImpl();
        try {
            DBUtil.getConnection();
            orders = ordersDao.getOrdersByIdDao(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserIdService(String userId) {
        List<Orders> list = new ArrayList<>();
        OrdersDao ordersDao = new OrdersDaoImpl();
        try {
            DBUtil.getConnection();
            list = ordersDao.listOrdersByUserIdDao(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
