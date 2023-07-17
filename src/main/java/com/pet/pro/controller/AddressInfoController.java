package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.AddressInfoEntity;
import com.pet.pro.mapper.AddressInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("AddressInfoController")
@RequestMapping("/address-info-entity")
public class AddressInfoController {

    AddressInfoMapper addressInfoMapper;
    @Autowired
    public void setAddressInfoMapper(AddressInfoMapper addressInfoMapper){
        this.addressInfoMapper = addressInfoMapper;
    }


    @GetMapping("/getMyAddressInfo/{userId}")//获得当前用户地址信息
    public Result<List<AddressInfoEntity>> getAllAddressInfo(@PathVariable int userId){
        List<AddressInfoEntity> list =addressInfoMapper.selectList(new QueryWrapper<AddressInfoEntity>().eq("user_id",userId));
        return Result.success(list);

    }

    @PostMapping("/addAddressInfo")//添加地址信息
    public Result<Integer> addAddressInfo(@RequestBody AddressInfoEntity addressInfoEntity){
        addressInfoMapper.insert(addressInfoEntity);
        return Result.success(addressInfoEntity.getAddressId(),"添加成功");
    }

    @DeleteMapping("/deleteAddressInfo/{addressId}")//删除地址信息
    public Result<List<AddressInfoEntity>> deleteAddressInfo(@PathVariable int addressId){
        addressInfoMapper.deleteById(addressId);
        return Result.success("删除成功");
    }

    @PutMapping("/updateAddressInfo")//更新地址信息
    public Result<List<AddressInfoEntity>> updateAddressInfo(@RequestBody AddressInfoEntity addressInfoEntity){
        addressInfoMapper.updateById(addressInfoEntity);
        return Result.success("更新成功");
    }
}

