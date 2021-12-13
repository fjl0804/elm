package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.CartDao;
import com.foreknow.elm.dao.OrderDetailetDao;
import com.foreknow.elm.dao.OrdersDao;
import com.foreknow.elm.dao.impl.CartDaoImpl;
import com.foreknow.elm.dao.impl.OrderDetailetDaoImpl;
import com.foreknow.elm.dao.impl.OrdersDaoImpl;
import com.foreknow.elm.po.Cart;
import com.foreknow.elm.po.OrderDetailet;
import com.foreknow.elm.po.Orders;
import com.foreknow.elm.service.OrderDetailetService;
import com.foreknow.elm.service.OrdersService;
import com.foreknow.elm.util.DBUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrdersServiceImpl implements OrdersService {

    @Override
    public int createOrders(String userId, Integer businessId, Integer daId, Double orderTotal) {
        CartDao cartDao = new CartDaoImpl();
        OrdersDao ordersDao = new OrdersDaoImpl();
        OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
        List<Cart> cartList = new ArrayList<>();
        int autoId = 0;
        try {
            DBUtil.getConnection();
            DBUtil.beginTransaction();
            //然后根据用户编号、商家编号从购物车表中查询所有数据
            cartList = cartDao.listCartDao(userId, businessId);
            //根据用户编号、商家编号、订单总金额、送货地址编号向订单表中添加一条记录，并获取自动生成的订单编号
            autoId = ordersDao.saveOrdersDao(userId, businessId, daId, orderTotal);
            //将购物车表中的数据和订单编号导入明细中
            List<OrderDetailet> orderDetailets = new ArrayList<>();
            for (int i = 0; i < cartList.size(); i++) {
                OrderDetailet orderDetailet = new OrderDetailet();
                orderDetailet.setOrderId(autoId);
                orderDetailet.setFoodId(cartList.get(i).getFoodId());
                orderDetailet.setQuantity(cartList.get(i).getQuantity());
                orderDetailets.add(orderDetailet);
            }
            //批量添加订单明细
            orderDetailetDao.saveOrderDetailDao(orderDetailets);
            //根据用户编号、商家编号删除购物车表中的数据
            cartDao.removeCartDao(userId, businessId,null);
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
        return autoId;
    }

    @Override
    public Orders getOrdersByIdService(Integer orderId) {
        Orders orders = new Orders();
        OrdersDao ordersDao = new OrdersDaoImpl();
        try {
            DBUtil.getConnection();
            orders = ordersDao.getOrdersByIdDao(orderId);
            OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
            List<OrderDetailet> list = orderDetailetDao.getOrderDetailetByOrderIdDao(orderId);
            //一对多
            orders.setOrderDetailets(list);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return orders;
    }

    @Override
    public List<Orders> listOrdersByUserIdService(String userId) {
        List<Orders> list = new ArrayList<>();
        OrdersDao ordersDao = new OrdersDaoImpl();
        try {
            DBUtil.getConnection();
            list = ordersDao.listOrdersByUserIdDao(userId);
            OrderDetailetDao orderDetailetDao = new OrderDetailetDaoImpl();
            for (int i = 0; i < list.size(); i++) {
                int orderId = list.get(i).getOrderId();
                List<OrderDetailet> orderDetailetList = orderDetailetDao.getOrderDetailetByOrderIdDao(orderId);
                //一对多
                list.get(i).setOrderDetailets(orderDetailetList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
