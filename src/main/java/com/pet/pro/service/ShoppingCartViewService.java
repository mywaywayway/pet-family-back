package com.pet.pro.service;

import com.pet.pro.entity.views.ShoppingCartViewEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ShoppingCartViewService extends IService<ShoppingCartViewEntity>{


    /**
     * @description: 根据用户普通id查询购物车视图列表
     * @param: [userId]
     * @return: com.pet.pro.entity.views.ShoppingCartViewEntity的列表
     *
     */
     public List<ShoppingCartViewEntity> getShoppingCartViewListByUserId(Integer userId);


}
