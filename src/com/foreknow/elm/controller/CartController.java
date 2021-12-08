package com.foreknow.elm.controller;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.CartService;
import com.foreknow.elm.service.impl.CartServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CartController {
    /**
     * 根据用户编号查询此用户所有购物车信息
     * 根据用户编号和商家编号，查询此用户购物车中某个商家的所有购物车信息
     * @param request
     * @return
     * @throws Exception
     */
    public List<Cart> listCart(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        CartService cartService = new CartServiceImpl();
        List<Cart> list = new ArrayList<>();
        list = cartService.listCartService(userId, businessId);
        return list;
    }

    /**
     * 向购物车表中添加一条记录
     * @param request
     * @return
     * @throws Exception
     */
    public int saveCart(HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer foodId = Integer.valueOf(request.getParameter("foodId"));
        CartService cartService = new CartServiceImpl();
        int result = 0;
        result = cartService.saveCartService(userId, businessId, foodId);
        return  result;
    }

    /**
     * 根据用户编号、商家编号、食品编号更新数量
     * @param request
     * @return
     * @throws Exception
     */
    public int updateCart(HttpServletRequest request)throws Exception{
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer foodId = Integer.valueOf(request.getParameter("foodId"));
        Integer quantity = Integer.valueOf(request.getParameter("quantity"));
        String userId = request.getParameter("userId");
        CartService cartService = new CartServiceImpl();
        int result = 0;
        result = cartService.updateCartService(businessId,foodId,quantity,userId);
        return result;
    }

    /**
     * 根据用户编号、商家编号、食品编号删除购物车表中的一条食品记录
     * 根据用户编号、商家编号删除购物车表中的多条条记录
     * @param request
     * @return
     * @throws Exception
     */
    public int removeCart (HttpServletRequest request)throws Exception{
        String userId = request.getParameter("userId");
        Integer businessId = Integer.valueOf(request.getParameter("businessId"));
        Integer foodId = Integer.valueOf(request.getParameter("foodId"));
        CartService cartService = new CartServiceImpl();
        int result = 0;
        result = cartService.removeCartService(userId, businessId, foodId);
        return result;
    }
}
