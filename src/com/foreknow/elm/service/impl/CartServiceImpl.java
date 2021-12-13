package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.dao.impl.UserDaoImpl;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.service.CartService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartServiceImpl implements CartService {
    @Override
    public List<Cart> listCartService(String userId, Integer businessId) {
        List<Cart> list = new ArrayList<>();
        CartDao cartDao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            list = cartDao.listCartDao(userId, businessId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public int saveCartService(String userId, Integer businessId, Integer foodId) {
        int result = 0;
        CartDao cartDao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = cartDao.saveCartDao(userId, businessId, foodId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int updateCartService(Integer businessId, Integer foodId, Integer quantity, String userId) {
        int result = 0;
        CartDao cartDao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = cartDao.updateCartDao(businessId, foodId, quantity, userId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int removeCartService(String userId, Integer businessId, Integer foodId) {
        int result = 0;
        CartDao cartDao = new CartDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = cartDao.removeCartDao(userId, businessId, foodId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
