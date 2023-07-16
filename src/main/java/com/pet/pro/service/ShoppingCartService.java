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

    /**
     * 根据购物车id增加购物车信息
     * @param shoppingCartEntity 购物车实体
     * @return 1?0 1：增加成功 0：增加失败
     * @see com.pet.pro.service.impl.ShoppingCartServiceImpl#addShoppingCart(ShoppingCartEntity)
     */
    int addShoppingCart(ShoppingCartEntity shoppingCartEntity);

    /**
     * 根据购物车id更新购物车信息
     * @param shoppingCartEntity 购物车实体
     * @return 1?0 1：更新成功 0：更新失败
     * @see com.pet.pro.service.impl.ShoppingCartServiceImpl#updateShoppingCartByShoppingCartId(ShoppingCartEntity)
     */
    int updateShoppingCartByShoppingCartId(ShoppingCartEntity shoppingCartEntity);

    /**
     * 根据购物车id删除购物车信息
     * @param shoppingCartId 购物车id
     * @return 1?0 1：删除成功 0：删除失败
     * @see com.pet.pro.service.impl.ShoppingCartServiceImpl#deleteShoppingCartByShoppingCartId(Integer)
     */
    int deleteShoppingCartByShoppingCartId(Integer shoppingCartId);

}
