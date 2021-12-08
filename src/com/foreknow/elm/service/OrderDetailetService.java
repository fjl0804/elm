package com.foreknow.elm.service;

import com.foreknow.elm.po.OrderDetailet;

import java.util.List;

public interface OrderDetailetService {
    public List<OrderDetailet> getOrderDetailetByOrderIdService (Integer orderId);
}
