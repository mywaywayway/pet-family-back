package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.DTO.AddCommodityDTO;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.service.impl.ComGoodsServiceImpl;
import com.pet.pro.service.impl.CommodityServiceImpl;
import com.pet.pro.service.impl.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@RestController
@RequestMapping("/commodity-entity")
public class CommodityController {


    private CommodityServiceImpl commodityServiceImpl;
    private ComGoodsServiceImpl comGoodsServiceImpl;

    private StorageServiceImpl storageServiceImpl;

    @Autowired
    public void setStorageServiceImpl(StorageServiceImpl storageServiceImpl) {
        this.storageServiceImpl = storageServiceImpl;
    }
    @Autowired
    public void setCommodityServiceImpl(CommodityServiceImpl commodityServiceImpl) {
        this.commodityServiceImpl = commodityServiceImpl;
    }
    @Autowired
    public void setComGoodsServiceImpl(ComGoodsServiceImpl comGoodsServiceImpl) {
        this.comGoodsServiceImpl = comGoodsServiceImpl;
    }
    /**
     * 添加商品
     * @param addCommodityDTO 增加的商品和库存实体信息
     * @return  Result<?>
     */
    @PostMapping("/addCommodity")
    public Result<?> addCommodity(@RequestBody AddCommodityDTO addCommodityDTO){

        UUID uuid = UUID.randomUUID();
        commodityServiceImpl.save(addCommodityDTO.getCommodity());
        StorageEntity storage = new StorageEntity();
        storage.setCommodityId(addCommodityDTO.getCommodity().getId());
        storage.setStorageId(uuid.toString());
        storage.setWarehouseId(addCommodityDTO.getWarehouseId());
        storage.setQuantity(addCommodityDTO.getNum());
        storageServiceImpl.save(storage);
        return Result.success();
    }

    /**
     * 根据商店id查询商品信息
     * @param shopId 商店id
     * @return  Result<?>  Result.data=商品列表
     */

    @GetMapping("/selectCommodityByShopId/{shopId}")
    public Result<List<CommodityEntity>> selectCommodityByShopId(@PathVariable int shopId){
        return Result.success(commodityServiceImpl.selectCommodityByShopId(shopId));
    }

    /**
     * 根据商品id查询商品信息
     * @param commodityId 商品id
     * @return  Result<?>  Result.data=商品实体
     */


    /**
     * 根据商品id查询商品视图信息
     * @param shopId 商店id
     * @return Result<?>  Result.data=商品视图信息列表
     */

    @GetMapping("/selectComGoodsViewByShopId/{shopId}")
    public  Result<List<ComGoodsView>> selectComGoodsViewByShopId(@PathVariable int shopId){
        return Result.success(comGoodsServiceImpl.getComGoodsListByShopId(shopId));
    }

    /**
     * 根据商品id修改商品信息
     * @param commodityEntity 商品实体
     * @return  Result<?>  Result.data=
     */
    @PostMapping("/updateCommodityById")
    public  Result<?> updateCommodityById(@RequestBody CommodityEntity commodityEntity){
        int flag=commodityServiceImpl.updateCommodityById(commodityEntity);
        if(flag==1){
            return Result.success("修改成功");
        }else {
            return Result.fail("修改失败");
        }
    }

    /**
     * 根据商品id查询商品信息
     * @param commodityId 商品id
     * @return  Result<?>  Result.data=商品实体
     */
    @GetMapping("/selectCommodityById/{commodityId}")
    public Result<CommodityEntity> selectCommodityById(@PathVariable int commodityId){
        return Result.success(commodityServiceImpl.selectCommodityById(commodityId));
    }

    /**
     * 根据商品id删除商品信息
     * @param commodityId 商品id
     * @return Result<?>  Result.code=200 删除成功
     */
    @GetMapping("/deleteCommodityById/{commodityId}")
    public Result<?> deleteCommodityById(@PathVariable int commodityId){
        int flag=commodityServiceImpl.deleteCommodityById(commodityId);
        if(flag==1){
            return Result.success("删除成功");
        }else {
            return Result.fail("删除失败");
        }
    }




}

