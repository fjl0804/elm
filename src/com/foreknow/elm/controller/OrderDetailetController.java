package com.foreknow.elm.controller;

import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.service.impl.OrderDetailetServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailetController {
    /**
     * 根据订单编号查询订单明细
     * @param request
     * @return
     * @throws Exception
     */
    public List<OrderDetailet> getDetailById(HttpServletRequest request) throws Exception{
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        OrderDetailetService orderDetailetService = new OrderDetailetServiceImpl();
        List<OrderDetailet> list = new ArrayList<>();
        list = orderDetailetService.getOrderDetailetByOrderIdService(orderId);
        return list;
    }
}
