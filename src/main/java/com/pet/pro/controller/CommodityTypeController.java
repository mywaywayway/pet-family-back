package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommodityTypeEntity;
import com.pet.pro.service.impl.CommodityTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商品类别 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/commodity-type-entity")
public class CommodityTypeController {

    private CommodityTypeServiceImpl commodityTypeServiceImpl;
    @Autowired
    public void setCommodityTypeServiceImpl(CommodityTypeServiceImpl commodityTypeServiceImpl) {
        this.commodityTypeServiceImpl = commodityTypeServiceImpl;
    }


    @ResponseBody
    @GetMapping("/selectAllCommodityType")
    public Result<List<CommodityTypeEntity>> selectAllCommodityType(){
        return Result.success(commodityTypeServiceImpl.selectAllCommodityType());
    }


}

