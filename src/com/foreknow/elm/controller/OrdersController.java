package com.foreknow.elm.controller;

import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.service.impl.OrdersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {

    public Orders getOrdersById(HttpServletRequest request) throws Exception {
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        OrdersService ordersService = new OrdersServiceImpl();
        Orders orders = new Orders();
        orders = ordersService.getOrdersByIdService(orderId);
        return orders;
    }

    public List<Orders> listOrdersByUserId (HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        OrdersService ordersService = new OrdersServiceImpl();
        List<Orders> list = new ArrayList<>();
        list = ordersService.listOrdersByUserIdService(userId);
        return list;
    }
}
