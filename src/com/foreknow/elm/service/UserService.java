package com.foreknow.elm.service;

import com.foreknow.elm.po.User;

public interface UserService {
    public User getUserByIdByPassService(String userId, String password);
    public int getUserByIdService(String userId);
    public int saveUserService(String userId, String userName, String password, Integer userSex);
}
