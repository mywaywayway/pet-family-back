package com.pet.pro.service;

import com.pet.pro.entity.ShoppingCartEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-16 11:05:57
 */
public interface ShoppingCartService extends IService<ShoppingCartEntity> {

    /**
     * 根据用户id获取购物车信息
     * @param userId 普通用户ID
     * @return 购物车信息
     * @see com.pet.pro.service.impl.ShoppingCartServiceImpl#getShoppingCartByUserId(Integer)
     */
    List<ShoppingCartEntity> getShoppingCartByUserId(Integer userId);
}
