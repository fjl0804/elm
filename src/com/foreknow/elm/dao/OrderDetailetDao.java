package com.foreknow.elm.dao;

import com.foreknow.elm.po.OrderDetailet;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailetDao {
    public List<OrderDetailet> getOrderDetailetByOrderIdDao (Integer orderId) throws SQLException;
}
