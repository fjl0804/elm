package com.foreknow.elm.service;

import com.foreknow.elm.po.OrderDetailet;

import java.util.List;

public interface OrderDetailetService {
    /**
     * 根据订单编号查询明细
     * @param orderId
     * @return
     */
    public List<OrderDetailet> getOrderDetailetByOrderIdService (Integer orderId);
}
