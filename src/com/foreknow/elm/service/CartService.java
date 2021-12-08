package com.foreknow.elm.service;

import com.foreknow.elm.po.Cart;

import java.util.List;

public interface CartService {
    public List<Cart> listCartService(String userId, Integer businessId);

    public int saveCartService(String userId, Integer businessId, Integer foodId);

    public int updateCartService(Integer businessId, Integer foodId, Integer quantity,String userId);

    public int removeCartService(String userId, Integer businessId, Integer foodId);
}
