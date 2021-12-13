package com.foreknow.elm.dao;

import com.foreknow.elm.po.DeliveryAddress;

import java.sql.SQLException;
import java.util.List;

public interface DeliveryAddressDao {
    /**
     * 根据用户编号查询所属送货地址
     * @param userId
     * @return
     * @throws SQLException
     */
    public List<DeliveryAddress> listDeliveryAddressByUserIdDao(String userId) throws SQLException;

    /**
     * 根据送货地址编号查询送货地址
     * @param daId
     * @return
     * @throws SQLException
     */
    public DeliveryAddress getDeliveryAddressByIdDao(Integer daId) throws SQLException;

    /**
     * 向送货地址表中添加一条记录
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @return
     * @throws SQLException
     */
    public int saveDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId) throws SQLException;

    /**
     * 根据送货地址编号更新送货地址信息
     * @param contactName
     * @param contactSex
     * @param contactTel
     * @param address
     * @param userId
     * @param daId
     * @return
     * @throws SQLException
     */
    public int updateDeliveryAddressDao(String contactName, Integer contactSex, String contactTel, String address, String userId, Integer daId) throws SQLException;

    /**
     * 根据送货地址编号删除一条记录
     * @param daId
     * @return
     * @throws SQLException
     */
    public int removeDeliveryAddressDao(Integer daId) throws SQLException;
}
