package com.pet.pro.controller;


import com.pet.pro.entity.ShopEntity;
import com.pet.pro.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商店信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/shop-entity")
public class ShopController {

    ShopService shopService;
    @Autowired
    public void setShopService(ShopService shopService){
        this.shopService = shopService;
    }


    @GetMapping("/getShopByMerchantId/{merchantId}")
    public List<ShopEntity> getShopByMerchantId(@PathVariable int merchantId){
        return shopService.getShopByMerchantId(merchantId);
    }

}

