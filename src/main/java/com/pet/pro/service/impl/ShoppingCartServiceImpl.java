package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pet.pro.entity.ShoppingCartEntity;
import com.pet.pro.mapper.ShoppingCartMapper;
import com.pet.pro.service.ShoppingCartService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-16 11:05:57
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCartEntity> implements ShoppingCartService {

    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    /**
     * 根据用户id获取购物车信息
     * @param userId 普通用户ID
     * @return 购物车信息
     * @see com.pet.pro.service.ShoppingCartService#getShoppingCartByUserId(Integer)
     */
    @Override
    public List<ShoppingCartEntity> getShoppingCartByUserId(Integer userId) {
        return shoppingCartMapper.selectList(Wrappers.<ShoppingCartEntity>lambdaQuery().eq(ShoppingCartEntity::getRegularUserId, userId));

    }

    /**
     * 根据购物车id增加购物车信息
     * @param shoppingCartEntity 购物车实体
     * @return 1?0 1：增加成功 0：增加失败
     * @see com.pet.pro.service.ShoppingCartService#addShoppingCart(ShoppingCartEntity)
     */
    @Override
    public int addShoppingCart(ShoppingCartEntity shoppingCartEntity) {
        return shoppingCartMapper.insert(shoppingCartEntity);
    }

    /**
     *  根据购物车id更新购物车信息
     * @param shoppingCartEntity 购物车实体
     * @return 1?0 1：更新成功 0：更新失败
     * @see com.pet.pro.service.ShoppingCartService#updateShoppingCartByShoppingCartId(ShoppingCartEntity)
     */
    @Override
    public int updateShoppingCartByShoppingCartId(ShoppingCartEntity shoppingCartEntity) {
        return shoppingCartMapper.updateById(shoppingCartEntity);
    }

    /**
     * 根据购物车id删除购物车信息
     * @param shoppingCartId 购物车id
     * @return 1?0 1：删除成功 0：删除失败
     * @see com.pet.pro.service.ShoppingCartService#deleteShoppingCartByShoppingCartId(Integer)
     */
    @Override
    public int deleteShoppingCartByShoppingCartId(Integer shoppingCartId) {
        return shoppingCartMapper.deleteById(shoppingCartId);
    }

}
