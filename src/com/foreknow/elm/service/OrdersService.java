package com.foreknow.elm.service;

import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrdersService {
    /**
     * 生成订单
     * @param userId
     * @param businessId
     * @param daId
     * @param orderTotal
     * @return
     */
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal);

    /**
     * 根据订单编号查询订单信息，包括所属商家信息，和此订单的所有订单明细信息
     * @param orderId
     * @return
     */
    public Orders getOrdersByIdService(Integer orderId);

    /**
     * 根据用户编号查询此用户的所有订单信息
     * @param userId
     * @return
     */
    public List<Orders> listOrdersByUserIdService(String userId);
}
