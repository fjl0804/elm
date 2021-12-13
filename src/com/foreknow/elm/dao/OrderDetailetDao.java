package com.foreknow.elm.dao;

import com.foreknow.elm.po.OrderDetailet;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailetDao {
    /**
     * 根据订单编号查询订单明细
     * @param orderId
     * @return
     * @throws SQLException
     */
    public List<OrderDetailet> getOrderDetailetByOrderIdDao (Integer orderId) throws SQLException;

    /**
     * 批量添加明细
     * @param list
     * @return
     * @throws SQLException
     */
    public int saveOrderDetailDao (List<OrderDetailet> list) throws SQLException;
}
