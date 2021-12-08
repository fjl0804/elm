package com.foreknow.elm.dao;

import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodDao {
    /**
     * 根据商家编号查询所属食品信息
     * @param businessId 商家编号
     * @return food数组
     * @throws Exception
     */
    public List<Food> listFoodByBusinessIdDao(String businessId) throws Exception;
}
