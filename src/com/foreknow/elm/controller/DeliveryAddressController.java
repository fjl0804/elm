package com.foreknow.elm.controller;

import com.foreknow.elm.po.DeliveryAddress;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.DeliveryAddressService;
import com.foreknow.elm.service.impl.DeliveryAddressServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class DeliveryAddressController {
    /**
     * 根据用户编号查询所属送货地址
     * @param request
     * @return
     * @throws Exception
     */
    public List<DeliveryAddress> listDeliveryAddressByUserId(HttpServletRequest request) throws Exception{
        String userId = request.getParameter("userId");
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        List<DeliveryAddress> list = new ArrayList<>();
        list = deliveryAddressService.listDeliveryAddressByUserIdService(userId);
        return list;
    }

    /**
     * 根据送货地址编号查询送货地址
     * @param request
     * @return
     * @throws Exception
     */
    public DeliveryAddress getDeliveryAddressById(HttpServletRequest request) throws Exception{
        Integer daId = Integer.valueOf(request.getParameter("daId"));
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        DeliveryAddress deliveryAddress = new DeliveryAddress();
        deliveryAddress = deliveryAddressService.getDeliveryAddressByIdService(daId);
        return deliveryAddress;
    }

    /**
     * 向送货地址表中添加一条记录
     * @param request
     * @return
     * @throws Exception
     */
    public int saveDeliveryAddress(HttpServletRequest request) throws Exception {
        String contactName = request.getParameter("contactName");
        Integer contactSex = Integer.parseInt((request.getParameter("contactSex")));
        String contactTel = request.getParameter("contactTel");
        String address = request.getParameter("address");
        String userId = request.getParameter("userId");
        int result = 0;
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        result = deliveryAddressService.saveDeliveryAddressService(contactName, contactSex, contactTel, address, userId);
        return result;
    }

    /**
     * 根据送货地址编号更新送货地址信息
     * @param request
     * @return
     * @throws Exception
     */
    public int updateDeliveryAddress (HttpServletRequest request) throws Exception {
        String contactName = request.getParameter("contactName");
        Integer contactSex = Integer.parseInt((request.getParameter("contactSex")));
        String contactTel = request.getParameter("contactTel");
        String address = request.getParameter("address");
        String userId = request.getParameter("userId");
        Integer daId = Integer.parseInt(request.getParameter("daId"));
        int result = 0;
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        result = deliveryAddressService.updateDeliveryAddressService(contactName, contactSex, contactTel, address, userId, daId);
        return result;
    }

    /**
     * 根据送货地址编号删除一条记录
     * @param request
     * @return
     * @throws Exception
     */
    public int removeDeliveryAddress(HttpServletRequest request) throws Exception{
        Integer daId = Integer.parseInt(request.getParameter("daId"));
        int result = 0;
        DeliveryAddressService deliveryAddressService = new DeliveryAddressServiceImpl();
        result = deliveryAddressService.removeDeliveryAddressService(daId);
        return result;
    }
}
