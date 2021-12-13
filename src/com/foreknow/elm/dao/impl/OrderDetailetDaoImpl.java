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
        String sql = "select * from orderDetailet od left outer join food fd on  od.foodId=fd.foodId where orderId = ?";
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
                orderDetailet.setFood(food);
                list.add(orderDetailet);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

    @Override
    public int saveOrderDetailDao(List<OrderDetailet> list) throws SQLException {
        int result = 0;
        //根据list长度确定sql语句
        StringBuffer stringBuffer = new StringBuffer("insert into orderDetailet(orderId,foodId,quantity) values(?,?,?)");
        for (int i = 1; i < list.size(); i++){
            stringBuffer.append(",(?,?,?)");
        }
        String sql = stringBuffer.toString();
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            //对?传参
            for (int i = 0; i < list.size(); i++){
                pst.setInt(1+i*3, list.get(i).getOrderId());
                pst.setInt(2+i*3, list.get(i).getFoodId());
                pst.setInt(3+i*3, list.get(i).getQuantity());
            }
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }
}
