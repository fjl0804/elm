package com.foreknow.elm.controller;

import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.service.impl.OrdersServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class OrdersController {
    /**
     * 生成订单
     * @param request
     * @return
     * @throws Exception
     */
    public int createOrders(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        Double orderTotal = Double.parseDouble(request.getParameter("orderTotal"));
        OrdersService ordersService = new OrdersServiceImpl();
        int orderId = 0;
        orderId = ordersService.createOrders(userId, businessId, daId, orderTotal);
        return orderId;
    }

    /**
     * 根据订单编号查询订单信息，包括所属商家信息，和此订单的所有订单明细信息
     * @param request
     * @return
     * @throws Exception
     */
    public Orders getOrdersById(HttpServletRequest request) throws Exception {
        Integer orderId = Integer.valueOf(request.getParameter("orderId"));
        OrdersService ordersService = new OrdersServiceImpl();
        Orders orders = new Orders();
        orders = ordersService.getOrdersByIdService(orderId);
        return orders;
    }

    /**
     * 根据用户编号查询此用户的所有订单信息
     * @param request
     * @return
     * @throws Exception
     */
    public List<Orders> listOrdersByUserId(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        OrdersService ordersService = new OrdersServiceImpl();
        List<Orders> list = new ArrayList<>();
        list = ordersService.listOrdersByUserIdService(userId);
        return list;
    }
}
