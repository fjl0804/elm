package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.service.impl.OrderDetailetServiceImpl;
import com.foreknow.elm.util.CommonUtil;
import com.foreknow.elm.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public int saveOrdersDao(String userId, Integer businessId, Integer daId, Double orderTotal) throws SQLException {
        int defaultId = 0;
        String sql = "insert into orders(userId,businessId,daId,orderTotal,orderDate) values(?,?,?,?,?)";
        try {
            String orderDate = CommonUtil.getCurrentDate();
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,userId);
            pst.setInt(2,businessId);
            pst.setInt(3,daId);
            pst.setDouble(4,orderTotal);
            pst.setString(5,orderDate);
            pst.executeUpdate();
            rs = pst.getGeneratedKeys();
            if (rs.next()){
                defaultId = rs.getInt(1);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return defaultId;
    }

    @Override
    public Orders getOrdersByIdDao(Integer orderId) throws SQLException {
        Orders orders = new Orders();
        String sql = "select * from orders od left outer join business bu on od.businessId=bu.businessId left outer join orderdetailet ol on od.orderId=ol.orderId where od.orderId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Business business = new Business();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setUserId(rs.getString("userId"));
                orders.setBusinessId(rs.getInt("businessId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setOrderTotal(rs.getDouble("orderTotal"));
                orders.setDaId(rs.getInt("daId"));
                orders.setOrderState(rs.getInt("orderState"));
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                orders.setBusiness(business);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserIdDao(String userId) throws SQLException {
        List<Orders> list = new ArrayList<>();
        String sql = "select * from orders od left outer join business bu on od.businessId=bu.businessId left outer join orderdetailet ol on od.orderId=ol.orderId where od.userId=?";
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
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
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                orders.setBusiness(business);
                list.add(orders);
            }
        }finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

}
