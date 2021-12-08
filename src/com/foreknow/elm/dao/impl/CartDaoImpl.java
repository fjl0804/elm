package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<Cart> listCartDao(String userId, Integer businessId) throws SQLException {
        List<Cart> list = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer("select * from cart c, business b, food f where c.businessId=b.businessId and c.foodId = f.foodId and c.userId = ?");
        if (businessId != null) {
            stringBuffer.append(" and c.businessId = ?");
        }
        String sql = stringBuffer.toString();
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setInt(2, businessId);
            rs = pst.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                Business business = new Business();
                Food food = new Food();
                cart.setCartId(rs.getInt("cartId"));
                cart.setFoodId(rs.getInt("foodId"));
                cart.setBusinessId(rs.getInt("businessId"));
                cart.setUserId(rs.getString("userId"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setBusiness(business);
                cart.setFood(food);
                business.setBusinessName(rs.getString("businessName"));
                business.setBusinessAddress(rs.getString("businessAddress"));
                business.setBusinessExplain(rs.getString("businessExplain"));
                business.setBusinessImg(rs.getString("businessImg"));
                business.setOrderTypeId(rs.getInt("orderTypeId"));
                business.setStarPrice(rs.getDouble("starPrice"));
                business.setDeliveryPrice(rs.getDouble("deliveryPrice"));
                business.setRemarks(rs.getString("remarks"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodImg(rs.getString("foodImg"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                food.setBusinessId(rs.getInt("businessId"));
                food.setRemarks(rs.getString("remarks"));
                list.add(cart);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

    @Override
    public int saveCartDao(String userId, Integer businessId, Integer foodId) throws SQLException {
        int result = 0;
        final int defaultQuantity = 1;
        String sql = "insert into cart(userId,businessId,foodId,quantity) values(?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setInt(2, businessId);
            pst.setInt(3, foodId);
            pst.setInt(4, defaultQuantity);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }

    @Override
    public int updateCartDao(Integer businessId, Integer foodId, Integer quantity, String userId) throws SQLException {
        int result = 0;
        String sql = "update cart set businessId=?,foodId=?,quantity=? where userId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, businessId);
            pst.setInt(2, foodId);
            pst.setInt(3, quantity);
            pst.setString(4, userId);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;

    }

    @Override
    public int removeCartDao(String userId, Integer businessId, Integer foodId) throws SQLException {
        int result = 0;
        StringBuffer stringBuffer = new StringBuffer("delete from cart where userId = ? and businessId = ?");
        if (foodId != null) {
            stringBuffer.append(" and foodId = ?");
        }
        String sql = stringBuffer.toString();
        try{
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setInt(2, businessId);
            pst.setInt(3, foodId);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }
}
