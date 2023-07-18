package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.ShoppingCartEntity;
import com.pet.pro.entity.views.ShoppingCartViewEntity;
import com.pet.pro.service.ShoppingCartService;
import com.pet.pro.service.ShoppingCartViewService;
import com.pet.pro.service.impl.ShoppingCartServiceImpl;
import com.pet.pro.service.impl.ShoppingCartViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
     * 根据用户id获取购物车视图信息列表（分店铺）
     *
     * @param userId 普通用户ID
     * @return 购物车视图信息列表 HashMap<String,List<ShoppingCartViewEntity>>
     */
    @ResponseBody
    @GetMapping("/getShoppingCartViewByUserIdAndStoreId/{userId}")
    public Result<HashMap<String,List<ShoppingCartViewEntity>>> getCartInfoByUserId(@PathVariable Integer userId) {
        if (userId == null) {
            return Result.fail("用户id不能为空");
        } else {
            List<ShoppingCartViewEntity> list = shoppingCartViewService.getShoppingCartViewListByUserId(userId);
            HashMap<String, List<ShoppingCartViewEntity>> map = new HashMap<>();  //<店铺名，购物车视图信息列表>
            map = list.stream().collect(HashMap::new, (m, v) -> {
                if (m.containsKey(v.getShopName())) {
                    m.get(v.getShopName()).add(v);
                } else {
                    List<ShoppingCartViewEntity> l = new java.util.ArrayList<>();
                    l.add(v);
                    m.put(v.getShopName(), l);
                }
            }, HashMap::putAll);
            return Result.success(map, "获取成功");
        }
    }

    

}

