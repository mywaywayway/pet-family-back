package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.ShoppingCartEntity;
import com.pet.pro.entity.Vo.CartInfoData;
import com.pet.pro.entity.views.ShoppingCartViewEntity;
import com.pet.pro.service.ShoppingCartService;
import com.pet.pro.service.ShoppingCartViewService;
import com.pet.pro.service.impl.ShoppingCartServiceImpl;
import com.pet.pro.service.impl.ShoppingCartViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController("ShoppingCartController")
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
     *
     * @param userId 普通用户ID
     * @return 购物车信息列表
     */
    @GetMapping("/getShoppingCartByUserId/{userId}")
    public Result<List<ShoppingCartEntity>> getShoppingCartByUserId(@PathVariable Integer userId) {
        return Result.success(shoppingCartService.getShoppingCartByUserId(userId));
    }

    /**
     * 根据用户id获取购物车视图信息列表
     *
     * @param userId 普通用户ID
     * @return 购物车视图信息列表 List<ShoppingCartViewEntity>
     */
    @GetMapping("/getShoppingCartViewByUserId/{userId}")
    public Result<List<ShoppingCartViewEntity>> getShoppingCartViewByUserId(@PathVariable Integer userId) {
        return Result.success(shoppingCartViewService.getShoppingCartViewListByUserId(userId));
    }

    /**
     * 根据用户id获取购物车视图信息列表（分店铺）
     *
     * @param userId 普通用户ID
     * @return 购物车视图信息列表 HashMap<String,List<ShoppingCartViewEntity>>
     */
    @ResponseBody
    @GetMapping("/getShoppingCartViewByUserIdAndStoreId/{userId}")
    public Result<List<CartInfoData>> getCartInfoByUserId(@PathVariable Integer userId) {
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
            //将map转换为List<CartInfoData>
            List<CartInfoData> cartInfoDataList = new java.util.ArrayList<>();
            for (Map.Entry<String, List<ShoppingCartViewEntity>> entry : map.entrySet()) {
                CartInfoData cartInfoData = new CartInfoData();
                cartInfoData.setShopName(entry.getKey());
                cartInfoData.setGoodsViewList(entry.getValue());;
                cartInfoDataList.add(cartInfoData);
            }
            return Result.success(cartInfoDataList, "获取成功");
        }
    }

    /**
     * 根据购物车id批量删除购物车信息
     * @param shoppingCartIdList 购物车id列表 List<Integer>
     *                           @return 删除结果
     */
    @PostMapping("/deleteShoppingCartByIdList")
    public Result<String> deleteShoppingCartByIdList(@RequestBody List<Integer> shoppingCartIdList) {
        if (shoppingCartIdList == null) {
            return Result.fail("购物车id列表不能为空");
        } else {
            shoppingCartService.removeBatchByIds(shoppingCartIdList);
            return Result.success("删除成功");
        }
    }

    

}

