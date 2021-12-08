package com.foreknow.elm.dao.impl;

import com.foreknow.elm.dao.DeliveryAddressDao;
import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressDaoImpl implements DeliveryAddressDao {
    private Connection con = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserIdDao(String userId) throws SQLException {
        List<DeliveryAddress> list = new ArrayList<>();
        String sql = "select address from DeliveryAddress where userId = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, userId);
            rs = pst.executeQuery();
            while (rs.next()) {
                DeliveryAddress deliveryAddress = new DeliveryAddress();
                deliveryAddress.setAddress(rs.getString("address"));
                list.add(deliveryAddress);
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return list;
    }

    @Override
    public DeliveryAddress getDeliveryAddressByIdDao(Integer daId) throws SQLException {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        String sql = "select address from deliveryAddress where daId = ?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, daId);
            rs = pst.executeQuery();
            while (rs.next()) {
                deliveryAddress.setAddress(rs.getString("address"));
            }
        } finally {
            DBUtil.close(rs, pst);
        }
        return deliveryAddress;
    }

    @Override
    public int saveDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId) throws SQLException {
        int result = 0;
        String sql = "insert into deliveryAddress(contactName,contactSex,contactTel,address,userId) values(?,?,?,?,?)";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, contactName);
            pst.setInt(2, contactSex);
            pst.setString(3, contactTel);
            pst.setString(4, address);
            pst.setString(5, userId);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;


    }

    @Override
    public int updateDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId) throws SQLException {
        int result = 0;
        String sql = "update deliveryAddress set contactName=?,contactSex=?,contactTel=?,address=?,userId=? where daId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1, contactName);
            pst.setInt(2, contactSex);
            pst.setString(3, contactTel);
            pst.setString(4, address);
            pst.setString(5, userId);
            pst.setInt(6, daId);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }

    @Override
    public int removeDeliveryAddressDao(Integer daId) throws SQLException {
        int result = 0;
        String sql = "delete from deliveryAddress where daId=?";
        try {
            con = DBUtil.getConnection();
            pst = con.prepareStatement(sql);
            pst.setInt(1, daId);
            int rs = pst.executeUpdate();
            result = rs;
        } finally {
            DBUtil.close(rs, pst);
        }
        return result;
    }
}


