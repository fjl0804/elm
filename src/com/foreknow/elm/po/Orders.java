package com.foreknow.elm.po;

import com.foreknow.elm.po.Business;
import com.foreknow.elm.po.OrderDetailet;

import java.util.List;

public class Orders {
    //订单编号
    private Integer orderId;
    //用户编号
    private String userId;
    //商家编号
    private Integer businessId;
    //下单时间
    private String orderDate;
    //订单总价
    private Double orderTotal;
    //配送地址编号
    private Integer daId;
    //订单完成状态
    private Integer orderState;

    private Business business;
    private List<OrderDetailet> orderDetailets;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getDaId() {
        return daId;
    }

    public void setDaId(Integer daId) {
        this.daId = daId;
    }

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public List<OrderDetailet> getOrderDetailets() {
        return orderDetailets;
    }

    public void setOrderDetailets(List<OrderDetailet> orderDetailets) {
        this.orderDetailets = orderDetailets;
    }
}
