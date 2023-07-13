package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.mapper.StorageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 库存信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/storage-entity")
public class StorageController {

    @Autowired
    private StorageMapper storageMapper;

    @GetMapping("/getStorageById/{commodityId}")
    public Result<?> getStorageById(@PathVariable Integer commodityId){
//        System.out.println(commodityId+"ceshi");
        LambdaQueryWrapper<StorageEntity> query = new LambdaQueryWrapper<>();
        query.eq(StorageEntity::getCommodityId,commodityId);
        StorageEntity storageEntity = storageMapper.selectOne(query);
        if(storageEntity==null){
            return Result.success(0);
        }
        else{
            return Result.success(storageEntity.getQuantity());
        }
    }


}

