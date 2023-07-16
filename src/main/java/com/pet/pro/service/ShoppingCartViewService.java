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


    /**
     * @description: 根据购物车Id来删除购物车商品信息
     * @param shoppingCartId 购物车Id
     * @return int 1？0 1表示删除成功，0表示删除失败
     */
    public int deleteShoppingCartViewById(Integer shoppingCartId);


}
