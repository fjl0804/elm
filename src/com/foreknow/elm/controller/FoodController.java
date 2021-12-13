package com.foreknow.elm.controller;

import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.FoodService;
import com.foreknow.elm.service.impl.FoodServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class FoodController {
    /**
     * 根据businessId查询商家所属食品的信息
     * @param request
     * @return
     * @throws Exception
     */
    public List<Food> listFoodByBusinessId(HttpServletRequest request) throws Exception {
        String businessId = request.getParameter("businessId");
        FoodService foodService = new FoodServiceImpl();
        List<Food> list = new ArrayList<>();
        list = foodService.listFoodByBusinessIdService(businessId);
        return list;
    }
}
