package com.foreknow.elm.dao;

import com.foreknow.elm.po.User;

import java.sql.SQLException;

public interface UserDao {
    /**
     * 根据用户编号与密码查询用户信息
     * @param userId
     * @param password
     * @return
     * @throws SQLException
     */
    public User getUserByIdByPassDao(String userId, String password) throws SQLException;

    /**
     * 根据用户编号查询用户表返回的行数
     * @param userId
     * @return
     * @throws SQLException
     */
    public int getUserByIdDao(String userId) throws SQLException;

    /**
     * 向用户表中添加一条记录
     * @param userId
     * @param userName
     * @param password
     * @param userSex
     * @return
     * @throws SQLException
     */
    public int saveUserDao(String userId, String userName, String password, Integer userSex) throws SQLException;
}
