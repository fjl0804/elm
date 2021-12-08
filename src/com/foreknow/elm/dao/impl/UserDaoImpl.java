package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.UserDao;
import com.foreknow.elm.po.User;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public User getUserByIdByPassDao(String userId, String password) throws SQLException {
        User user = new User();
        String sql = "select * from user where userId = ? and password = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, password);
            rs = pst.executeQuery();
            while (rs.next()) {
                user.setUserId(rs.getString("userId"));
                user.setPassword(rs.getString("password"));
                user.setUserName(rs.getString("userName"));
                user.setUserSex(rs.getInt("userSex"));
                user.setUserImg(rs.getString("userImg"));
                user.setDelTag(rs.getInt("delTag"));
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return user;
    }

    @Override
    public int getUserByIdDao(String userId) throws SQLException {
        List<User> list = new ArrayList<>();
        String sql = "select userId from user where userId = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getString("userId"));
                list.add(user);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list.size();
    }

    @Override
    public int saveUserDao(String userId, String userName, String password, Integer userSex) throws SQLException {
        int result = 0;
        String sql = "insert into user(userId,userName,password,userSex) values(?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            pst.setString(2, userName);
            pst.setString(3, password);
            pst.setInt(4, userSex);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }
}
