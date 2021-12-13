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

    /**
     * 向购物车表中添加一条记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     * @throws SQLException
     */
    public int saveCartDao(String userId, Integer businessId, Integer foodId) throws SQLException;

    /**
     * 根据用户编号、商家编号、食品编号更新数量
     * @param businessId
     * @param foodId
     * @param quantity
     * @param userId
     * @return
     * @throws SQLException
     */
    public int updateCartDao(Integer businessId, Integer foodId, Integer quantity,String userId) throws SQLException;

    /**
     * 根据用户编号、商家编号、食品编号删除购物车表中的一条食品记录
     * 根据用户编号、商家编号删除购物车表中的多条条记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     * @throws SQLException
     */
    public int removeCartDao(String userId, Integer businessId, Integer foodId) throws SQLException;
}
