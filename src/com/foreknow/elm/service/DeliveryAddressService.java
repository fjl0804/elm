package com.foreknow.elm.service;

import com.foreknow.elm.po.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressService {
    /**
     * 根据用户编号查询所属送货地址
     * @param userId
     * @return
     */
    public List<DeliveryAddress> listDeliveryAddressByUserIdService(String userId);

    /**
     * 根据送货地址编号查询送货地址
     * @param daId
     * @return
     */
    public DeliveryAddress getDeliveryAddressByIdService(Integer daId);

    /**
     * 向送货地址表中添加一条记录
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @return
     */
    public int saveDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId);

    /**
     * 根据送货地址编号更新送货地址信息
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @param daId
     * @return
     */
    public int updateDeliveryAddressService(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId);

    /**
     * 根据送货地址编号删除一条记录
     * @param daId
     * @return
     */
    public int removeDeliveryAddressService(Integer daId);
}
