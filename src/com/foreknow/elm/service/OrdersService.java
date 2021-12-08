package com.foreknow.elm.service;

import com.foreknow.elm.po.Orders;

import java.util.List;

public interface OrdersService {
    public Orders getOrdersByIdService(Integer orderId);

    public List<Orders> listOrdersByUserIdService(String userId);
}
