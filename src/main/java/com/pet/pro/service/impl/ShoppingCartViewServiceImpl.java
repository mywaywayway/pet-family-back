package com.pet.pro.service.impl;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.pet.pro.entity.views.ShoppingCartViewEntity;
import com.pet.pro.mapper.ShoppingCartViewMapper;
import com.pet.pro.service.ShoppingCartViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartViewServiceImpl extends ServiceImpl<ShoppingCartViewMapper, ShoppingCartViewEntity> implements ShoppingCartViewService {

    private  ShoppingCartViewMapper shoppingCartViewMapper;

    @Autowired
    public void setShoppingCartViewMapper(ShoppingCartViewMapper shoppingCartViewMapper){
        this.shoppingCartViewMapper = shoppingCartViewMapper;
    }

    @Override
    public List<ShoppingCartViewEntity> getShoppingCartViewListByUserId(Integer userId) {
        return shoppingCartViewMapper.selectList(Wrappers.<ShoppingCartViewEntity>lambdaQuery().eq(ShoppingCartViewEntity::getRegularUserId,userId));
    }
}
