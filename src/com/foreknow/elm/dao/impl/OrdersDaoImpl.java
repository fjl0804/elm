package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.service.impl.OrderDetailetServiceImpl;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public Orders getOrdersByIdDao(Integer orderId) throws SQLException {
        Orders orders = new Orders();
        String sql = "select * from orders od,business bu,orderdetailet ol where od.businessId=bu.businessId and od.orderId=ol.orderId and od.orderId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            OrderDetailetService orderDetailetService = new OrderDetailetServiceImpl();
            while (rs.next()) {
                Business business = new Business();
                List<OrderDetailet> orderDetailetList = orderDetailetService.getOrderDetailetByOrderIdService(orderId);
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                orders.setBusiness(business);
                orders.setOrderDetailets(orderDetailetList);
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserIdDao(String userId) throws SQLException {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from orders od,business bu,orderdetailet ol where od.businessId=bu.businessId and od.orderId=ol.orderId and od.userId=?";
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            OrderDetailetService orderDetailetService = new OrderDetailetServiceImpl();
            while (rs.next()) {
                Orders orders = new Orders();
                Business business = new Business();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                orders.setBusiness(business);
                List<OrderDetailet> orderDetailetList = orderDetailetService.getOrderDetailetByOrderIdService(orders.getOrderId());
                orders.setOrderDetailets(orderDetailetList);
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                list.add(orders);
            }
        }finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

}
