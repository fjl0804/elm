package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.dao.impl.UserDaoImpl;
import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    @Override
    public User getUserByIdByPassService(String userId, String password) {
        User user = new User();
        UserDao userDao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            user = userDao.getUserByIdByPassDao(userId, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return user;
    }

    @Override
    public int getUserByIdService(String userId) {
        int result = 0;
        UserDao userDao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            result = userDao.getUserByIdDao(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int saveUserService(String userId, String userName, String password, Integer userSex) {
        int result = 0;
        UserDao userDao = new UserDaoImpl();
        try {
            DBUtil.getConnection();
            result = userDao.saveUserDao(userId, userName, password, userSex);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
