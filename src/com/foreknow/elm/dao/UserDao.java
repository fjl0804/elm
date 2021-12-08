package com.foreknow.elm.dao;

import com.foreknow.elm.po.User;

import java.sql.SQLException;

public interface UserDao {
    public User getUserByIdByPassDao(String userId, String password) throws SQLException;
    public int getUserByIdDao(String userId) throws SQLException;
    public int saveUserDao(String userId, String userName, String password, Integer userSex) throws SQLException;
}
