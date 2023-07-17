package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.mapper.ShopMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pet.pro.service.impl.ShopServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @Autowired
    private ShopMapper shopMapper;

    @GetMapping("/getSHopInfo/{shopId}")
    public Result<?> getSHopInfo(@PathVariable String shopId){
        LambdaQueryWrapper<ShopEntity> query = new LambdaQueryWrapper<>();
        query.eq(ShopEntity::getId,shopId);
        ShopEntity shopEntity = shopMapper.selectOne(query);
        if(shopEntity!=null){
            return Result.success(shopEntity);
        }
        else{
            return Result.fail();
        }
    }

    @ResponseBody
    @GetMapping("/selectShopByMerchantId/{MerchantId}")
    public List<ShopEntity> selectShopByMerchantId(@PathVariable Integer MerchantId){
        if(MerchantId == null)
            return null;
        else
            return shopService.getBaseMapper().selectShopByMerchantId(MerchantId);
    }


    @GetMapping("/getShopByMerchantId/{merchantId}")
    public List<ShopEntity> getShopByMerchantId(@PathVariable int merchantId){
        return shopService.getShopByMerchantId(merchantId);
    }

    @ApiOperation("关闭店铺")
    @GetMapping("/closeShop/{id}")
    public Result<?> deleteShop(@PathVariable Integer id){
        QueryWrapper<ShopEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        ShopEntity shopEntity = shopService.getOne(wrapper);
        shopEntity.setShopStatus("歇业中");
        shopService.updateById(shopEntity);
        return Result.success();
    }

    /**DoubleHong
     * 根据店铺id查询店铺信息
     * @param shopId 店铺id
     * @return 店铺信息
     */
    @GetMapping("/getShopById/{shopId}")
    public Result<?> getShopById(@PathVariable int shopId){
        return shopService.getShopById(shopId);
    }

}

