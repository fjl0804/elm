package com.foreknow.elm.service;

import com.foreknow.elm.po.User;

public interface UserService {
    /**
     * 根据用户编号与密码查询用户信息
     * @param userId
     * @param password
     * @return
     */
    public User getUserByIdByPassService(String userId, String password);

    /**
     * 根据用户编号查询用户表返回的行数
     * @param userId
     * @return
     */
    public int getUserByIdService(String userId);

    /**
     * 向用户表中添加一条记录
     * @param userId
     * @param userName
     * @param password
     * @param userSex
     * @return
     */
    public int saveUserService(String userId, String userName, String password, Integer userSex);
}
