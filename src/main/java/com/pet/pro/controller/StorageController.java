package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.service.impl.StorageServiceImpl;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController("StorageController")
@RequestMapping("/storage-entity")
public class StorageController {

    private StorageServiceImpl storageServiceImpl;

    @Autowired
    public void setStorageServiceImpl(StorageServiceImpl storageServiceImpl) {
        this.storageServiceImpl = storageServiceImpl;
    }

    @PostMapping("/addStorage")
    public Result<?>  addStorage(@RequestBody StorageEntity storageEntity){
        int flag=storageServiceImpl.addStorage(storageEntity);
        if (flag==1){
            return Result.success("添加成功");
        }else {
            return Result.fail("添加失败");
        }
    }
}

