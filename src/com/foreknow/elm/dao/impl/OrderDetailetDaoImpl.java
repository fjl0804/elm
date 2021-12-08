package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.OrderDetailetDao;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailetDaoImpl implements OrderDetailetDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<OrderDetailet> getOrderDetailetByOrderIdDao(Integer orderId) throws SQLException {
        List<OrderDetailet> list = new ArrayList<>();
        String sql = "select * from orderDetailet od, food fd where od.foodId=fd.foodId orderId = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, orderId);
            rs = pst.executeQuery();
            while (rs.next()) {
                OrderDetailet orderDetailet = new OrderDetailet();
                Food food = new Food();
                orderDetailet.setOdId(rs.getInt("odId"));
                orderDetailet.setOrderId(rs.getInt("orderId"));
                orderDetailet.setFoodId(rs.getInt("foodId"));
                orderDetailet.setQuantity(rs.getInt("quantity"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                food.setRemarks(rs.getString("remarks"));
                list.add(orderDetailet);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }
}
