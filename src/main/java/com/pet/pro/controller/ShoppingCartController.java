package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.ShoppingCartEntity;
import com.pet.pro.entity.views.ShoppingCartViewEntity;
import com.pet.pro.service.impl.ShoppingCartServiceImpl;
import com.pet.pro.service.impl.ShoppingCartViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 购物车 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-16 11:05:57
 */
@RestController
@RequestMapping("/shopping-cart-entity")
public class ShoppingCartController {


    private ShoppingCartServiceImpl shoppingCartService;

    private ShoppingCartViewServiceImpl shoppingCartViewService;

    @Autowired
    public void setShoppingCartViewService(ShoppingCartViewServiceImpl shoppingCartViewService) {
        this.shoppingCartViewService = shoppingCartViewService;
    }

    @Autowired
    public ShoppingCartController(ShoppingCartServiceImpl shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    /**
     * 根据用户id获取购物车信息
     * @param userId 普通用户ID
     * @return  购物车信息列表
     */
    @GetMapping("/getShoppingCartByUserId/{userId}")
    public Result<List<ShoppingCartEntity>> getShoppingCartByUserId(@PathVariable  Integer userId) {
        return Result.success(shoppingCartService.getShoppingCartByUserId(userId));
    }
    /**
     * 根据用户id获取购物车视图信息列表
     * @param userId 普通用户ID
     * @return  购物车视图信息列表 List<ShoppingCartViewEntity>
     */
    @GetMapping("/getShoppingCartViewByUserId/{userId}")
    public Result<List<ShoppingCartViewEntity>> getShoppingCartViewByUserId(@PathVariable  Integer userId) {
        return Result.success(shoppingCartViewService.getShoppingCartViewListByUserId(userId));
    }
}

