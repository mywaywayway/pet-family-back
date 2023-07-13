package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.entity.views.MerchantUserView;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.MerchantUserViewMapper;
import com.pet.pro.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/administrator-entity")
public class AdministratorController {

    MerchantUserViewMapper merchantUserViewMapper;
    @Autowired
    public void setMerchantUserViewMapper(MerchantUserViewMapper merchantUserViewMapper){
        this.merchantUserViewMapper = merchantUserViewMapper;
    }

    ShopMapper shopMapper;
    @Autowired
    public void setShopMapper(ShopMapper shopMapper){
        this.shopMapper = shopMapper;
    }


    ComGoodsMapper comGoodsMapper;
    @Autowired
    public void setComGoodsMapper(ComGoodsMapper comGoodsMapper){
        this.comGoodsMapper = comGoodsMapper;
    }

    /** DoubleHong
     * 获取所有商家用户视图
     * @return 所有商家用户视图
     */
    @GetMapping("/getAllMerchantUser")
    public Result<List<MerchantUserView>> getAllMerchantUser(){
        return Result.success(merchantUserViewMapper.selectList(null));
    }

    @GetMapping("/getAllShopByMerchantId/{merchantId}")
    public Result<List<ShopEntity>> getAllShopByMerchantId(@PathVariable String merchantId){
        return Result.success(shopMapper.selectList(new QueryWrapper<ShopEntity>().eq("merchant_id",merchantId)));
    }

    @GetMapping("/getComGoodsByShopId/{shopId}")
    public Result<List<ComGoodsView>> getComGoodsByShopId(@PathVariable String shopId){
        return Result.success(comGoodsMapper.selectList(new QueryWrapper<ComGoodsView>().eq("shop_id",shopId)));
    }

}

