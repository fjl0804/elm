package com.foreknow.elm.service;

import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodService {
    /**
     * 根据商家编号查询所属食品信息
     * @param businessId
     * @return
     */
    public List<Food> listFoodByBusinessIdService(String businessId);
}
