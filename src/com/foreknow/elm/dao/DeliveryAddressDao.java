package com.foreknow.elm.dao;

import com.foreknow.elm.po.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressDao {
    public List<DeliveryAddress> listDeliveryAddressByUserIdDao(String userId) throws SQLException;
    public DeliveryAddress getDeliveryAddressByIdDao(Integer daId) throws SQLException;
    public int saveDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId) throws SQLException;
    public int updateDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId) throws SQLException;
    public int removeDeliveryAddressDao(Integer daId) throws SQLException;
}
