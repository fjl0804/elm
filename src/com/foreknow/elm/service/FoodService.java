package com.foreknow.elm.service;

import com.foreknow.elm.po.Food;

import java.util.List;

public interface FoodService {
    public List<Food> listFoodByBusinessIdService(String businessId);
}
