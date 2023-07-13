package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.WarehouseInfoEntity;
import com.pet.pro.service.impl.WarehouseInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("WarehouseInfoController")
@RequestMapping("/warehouse-info-entity")
public class WarehouseInfoController {

    private WarehouseInfoServiceImpl warehouseInfoServiceImpl;

    @Autowired
    public void setWarehouseInfoServiceImpl(WarehouseInfoServiceImpl warehouseInfoServiceImpl) {
        this.warehouseInfoServiceImpl = warehouseInfoServiceImpl;
    }

    /**
     * 查询所有仓库信息
     * @return  Result<List<WarehouseInfoEntity>>
     */
    @GetMapping("/selectAllWarehouseInfo")
    public Result<List<WarehouseInfoEntity>> selectAllWarehouseInfo(){
        return Result.success(warehouseInfoServiceImpl.selectAllWarehouseInfo());
    }

}

