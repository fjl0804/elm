package com.foreknow.elm.service;

import com.foreknow.elm.po.Cart;

import java.util.List;

public interface CartService {
    /**
     * 根据用户编号查询此用户所有购物车信息
     * 根据用户编号和商家编号，查询此用户购物车中某个商家的所有购物车信息
     * @param userId
     * @param businessId
     * @return
     */
    public List<Cart> listCartService(String userId, Integer businessId);

    /**
     * 向购物车表中添加一条记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     */
    public int saveCartService(String userId, Integer businessId, Integer foodId);

    /**
     * 根据用户编号、商家编号、食品编号更新数量
     * @param businessId
     * @param foodId
     * @param quantity
     * @param userId
     * @return
     */
    public int updateCartService(Integer businessId, Integer foodId, Integer quantity,String userId);

    /**
     * 根据用户编号、商家编号、食品编号删除购物车表中的一条食品记录
     * 根据用户编号、商家编号删除购物车表中的多条条记录
     * @param userId
     * @param businessId
     * @param foodId
     * @return
     */
    public int removeCartService(String userId, Integer businessId, Integer foodId);
}
