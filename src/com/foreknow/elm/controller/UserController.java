package com.foreknow.elm.controller;

import com.foreknow.elm.po.User;
import com.foreknow.elm.service.UserService;
import com.foreknow.elm.service.impl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UserController {
    /**
     * 根据用户编号与密码查询用户信息
     * @param request
     * @return
     * @throws Exception
     */
    public User getUserByIdByPass(HttpServletRequest request) throws Exception {
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        User user = new User();
        user = userService.getUserByIdByPassService(userId, password);
        return user;
    }

    /**
     * 根据用户编号查询用户表返回的行数
     * @param request
     * @return
     * @throws Exception
     */
    public int getUserById (HttpServletRequest request) throws Exception{
        String userId = request.getParameter("userId");
        UserService userService = new UserServiceImpl();
        int result = 0;
        result = userService.getUserByIdService(userId);
        return result;
    }

    /**
     * 向用户表中添加一条记录
     * @param request
     * @return
     * @throws Exception
     */
    public int saveUser(HttpServletRequest request) throws Exception{
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        Integer userSex = Integer.valueOf(request.getParameter("userSex"));
        UserService userService = new UserServiceImpl();
        int result = 0;
        result = userService.saveUserService(userId, userName, password, userSex);
        return result;
    }
}
