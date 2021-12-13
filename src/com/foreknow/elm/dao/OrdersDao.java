package com.foreknow.elm.dao;

import com.foreknow.elm.po.Orders;

import java.sql.SQLException;
import java.util.List;

public interface OrdersDao {
    /**
     * 创建订单
     * @param userId
     * @param businessId
     * @param daId
     * @param orderTotal
     * @return
     * @throws SQLException
     */
    public int saveOrdersDao(String userId, Integer businessId, Integer daId, Double orderTotal) throws SQLException;

    /**
     * 根据订单编号查询订单信息，包括所属商家信息，和此订单的所有订单明细信息
     * @param orderId
     * @return
     * @throws SQLException
     */
    public Orders getOrdersByIdDao(Integer orderId) throws SQLException;

    /**
     * 根据用户编号查询此用户的所有订单信息
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<Orders> listOrdersByUserIdDao(String userId) throws SQLException;
}
