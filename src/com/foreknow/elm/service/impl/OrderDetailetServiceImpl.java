package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.OrderDetailetDao;
import com.foreknow.elm.dao.impl.OrderDetailetDaoImpl;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailetServiceImpl implements OrderDetailetService {
    @Override
    public List<OrderDetailet> getOrderDetailetByOrderIdService(Integer orderId) {
        List<OrderDetailet> list = new ArrayList<>();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        try {
            DBUtil.getConnection();
            list = orderDetailetDao.getOrderDetailetByOrderIdDao(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
