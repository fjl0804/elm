package com.foreknow.elm.dao;

import com.foreknow.elm.po.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {

    public Orders getOrdersByIdDao(Integer orderId) throws SQLException;

    public List<Orders> listOrdersByUserIdDao(String userId) throws SQLException;
}
