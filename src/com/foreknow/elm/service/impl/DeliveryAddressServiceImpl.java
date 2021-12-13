package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.DeliveryAddressDao;
import com.foreknow.elm.dao.impl.DeliveryAddressDaoImpl;
import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.service.DeliveryAddressService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressServiceImpl implements DeliveryAddressService {
    @Override
    public List<DeliveryAddress> listDeliveryAddressByUserIdService(String userId) {
        List<DeliveryAddress> list = new ArrayList<>();
        DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            list = deliveryAddressDao.listDeliveryAddressByUserIdDao(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }

    @Override
    public DeliveryAddress getDeliveryAddressByIdService(Integer daId) {
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            deliveryAddress = deliveryAddressDao.getDeliveryAddressByIdDao(daId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return deliveryAddress;
    }

    @Override
    public int saveDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId) {
        int result = 0;
        DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = deliveryAddressDao.saveDeliveryAddressDao(contactName, contactSex, contactTel, address, userId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int updateDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId) {
        int result = 0;
        DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = deliveryAddressDao.updateDeliveryAddressDao(contactName, contactSex, contactTel, address, userId, daId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }

    @Override
    public int removeDeliveryAddressService(Integer daId) {
        int result = 0;
        DeliveryAddressDao deliveryAddressDao = new DeliveryAddressDaoImpl();
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            result = deliveryAddressDao.removeDeliveryAddressDao(daId);
            DBUtil.commitTransaction();
            try {
                DBUtil.rollbackTransaction();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return result;
    }
}
