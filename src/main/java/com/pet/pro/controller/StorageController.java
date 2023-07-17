package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.OrderGoodsEntity;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.mapper.StorageMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController("StorageController")
@RequestMapping("/storage-entity")
public class StorageController {

    private StorageServiceImpl storageServiceImpl;

    @Autowired
    public void setStorageServiceImpl(StorageServiceImpl storageServiceImpl) {
        this.storageServiceImpl = storageServiceImpl;
    }
    /**
     * 添加库存信息
     * @param storageEntity 库存实体
     * @return Result<?>
     */

    @PostMapping("/addStorage")
    public Result<?>  addStorage(@RequestBody StorageEntity storageEntity){
        int flag=storageServiceImpl.addStorage(storageEntity);
        if (flag==1){
            return Result.success("添加成功");
        }else {
            return Result.fail("添加失败");
        }
    }
    /**
     * 查询所有库存信息
     * @return Result<?>
     */
    @GetMapping("/selectAllStorage")
    public Result<?> selectAllStorage(){
        return Result.success(storageServiceImpl.selectAllStorage());
    }
    /**
     * 添加库存数量
     * @param storageEntity 库存实体
     * @return Result<?>
     */
    @PostMapping("/addStorageQuantity")
    public Result<?> addStorageQuantity(@RequestBody StorageEntity storageEntity){
        int flag=storageServiceImpl.addStorageQuantity(storageEntity);
        if (flag==1){
            return Result.success("添加成功");
        }else {
            return Result.fail("添加失败");
        }
    }
    private StorageMapper storageMapper;
    @Autowired
    public void setStorageMapper(StorageMapper storageMapper){
        this.storageMapper = storageMapper;
    }


//    栋梁
    @GetMapping("/getStorageById/{commodityId}")
    public Result<?> getStorageById(@PathVariable Integer commodityId){
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

    @PostMapping ("/cutStorage")
    public Result<?> getCutStorage(@RequestBody OrderGoodsEntity entity){
        LambdaQueryWrapper<StorageEntity> query = new LambdaQueryWrapper<>();
        query.eq(StorageEntity::getCommodityId,entity.getCommodityId());
        StorageEntity storageEntity = storageMapper.selectOne(query);
        System.out.println(storageEntity.getQuantity()+"修改前");
        storageEntity.setQuantity(storageEntity.getQuantity()-entity.getNum());
        System.out.println(storageEntity.getQuantity()+"修改后");
        if(storageMapper.updateById(storageEntity)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }

    @PostMapping("/addStorageHdl")
    public Result<?> addStorage(@RequestBody OrderGoodsEntity entity){
        int quantity = entity.getNum();
        int commodityId = entity.getCommodityId();
        LambdaQueryWrapper<StorageEntity> query = new LambdaQueryWrapper<>();
        query.eq(StorageEntity::getCommodityId,commodityId);
        StorageEntity storageEntity = storageMapper.selectOne(query);
        storageEntity.setQuantity(storageEntity.getQuantity()+entity.getNum());
        if(storageMapper.update(storageEntity,query)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }






}

