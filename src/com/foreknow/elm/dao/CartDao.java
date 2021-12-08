package com.foreknow.elm.dao;

import com.foreknow.elm.po.Cart;

import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    /**
     * 根据用户编号查询此用户所有购物车信息
     * 根据用户编号和商家编号，查询此用户购物车中某个商家的所有购物车信息
     * @param userId
     * @param businessId
     * @return
     * @throws SQLException
     */
    public List<Cart> listCartDao(String userId, Integer businessId) throws SQLException;

    public int saveCartDao(String userId, Integer businessId, Integer foodId) throws SQLException;

    public int updateCartDao(Integer businessId, Integer foodId, Integer quantity,String userId) throws SQLException;

    public int removeCartDao(String userId, Integer businessId, Integer foodId) throws SQLException;
}
