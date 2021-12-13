package com.foreknow.elm.service.impl;

import com.foreknow.elm.dao.FoodDao;
import com.foreknow.elm.dao.impl.FoodDaoImpl;
import com.foreknow.elm.po.Food;
import com.foreknow.elm.service.FoodService;
import com.foreknow.elm.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    @Override
    public List<Food> listFoodByBusinessIdService(String businessId) {
        List<Food> list = new ArrayList<>();
        FoodDao foodDao = new FoodDaoImpl();
        try {
            DBUtil.getConnection();
            list = foodDao.listFoodByBusinessIdDao(businessId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return list;
    }
}
