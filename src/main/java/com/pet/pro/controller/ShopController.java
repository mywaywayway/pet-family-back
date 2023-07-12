package com.pet.pro.controller;


import com.pet.pro.entity.ShopEntity;
import com.pet.pro.service.impl.ShopServiceImpl;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商家信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@RestController("ShopController")
@CrossOrigin
@RequestMapping("/shop-entity")
public class ShopController {

    private final ShopServiceImpl shopService;

    @Autowired
    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    /**
     * 根据商家id查询店铺信息
     * @param MerchantId 商家id
     *           @return 店铺信息
     */
    @ResponseBody
    @GetMapping("/selectShopByMerchantId/{MerchantId}")
    public List<ShopEntity> selectShopByMerchantId(@PathVariable Integer MerchantId){
        if(MerchantId == null)
            return null;
        else
            return shopService.getBaseMapper().selectShopByMerchantId(MerchantId);
    }
}

