package com.foreknow.elm.service;

import com.foreknow.elm.po.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressService {
    public List<DeliveryAddress> listDeliveryAddressByUserIdService(String userId);
    public DeliveryAddress getDeliveryAddressByIdService(Integer daId);
    public int saveDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId);
    public int updateDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId);
    public int removeDeliveryAddressService(Integer daId);
}
