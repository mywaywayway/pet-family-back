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

}
