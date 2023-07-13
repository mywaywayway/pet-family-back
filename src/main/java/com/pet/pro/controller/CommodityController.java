package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.impl.ComGoodsServiceImpl;
import com.pet.pro.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@RestController
@RequestMapping("/commodity-entity")
public class CommodityController {


    private CommodityServiceImpl commodityServiceImpl;
    private ComGoodsServiceImpl comGoodsServiceImpl;
    @Autowired
    public void setCommodityServiceImpl(CommodityServiceImpl commodityServiceImpl) {
        this.commodityServiceImpl = commodityServiceImpl;
    }
    @Autowired
    public void setComGoodsServiceImpl(ComGoodsServiceImpl comGoodsServiceImpl) {
        this.comGoodsServiceImpl = comGoodsServiceImpl;
    }

    @Autowired
    private CommodityMapper commodityMapper;
    /**
     * 添加商品
     * @param commodityEntity 增加的商品实体信息
     * @return  Result<?>
     */
    @PostMapping("/addCommodity")
    public Result<?> addCommodity(@RequestBody CommodityEntity commodityEntity){
        int flag= commodityServiceImpl.addCommodity(commodityEntity);
        if(flag==1){
            return Result.success("添加成功");
        }else {
            return Result.fail("添加失败");
        }
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
     * 根据商品id查询商品视图信息
     * @param shopId 商店id
     * @return Result<?>  Result.data=商品视图信息列表
     */

    @GetMapping("/selectComGoodsViewByShopId/{shopId}")
    public  Result<List<ComGoodsView>> selectComGoodsViewByShopId(@PathVariable int shopId){
        return Result.success(comGoodsServiceImpl.getComGoodsListByShopId(shopId));
    }



    /** DoubleHong
     * 获取所有的商品视图
     * @return Result<?>  Result.data=商品视图信息列表
     */
    @GetMapping("/getAllComGoodsView")
    public Result<List<ComGoodsView>> getAllComGoodsView(){
        return Result.success(comGoodsServiceImpl.getAllGoods());
    }


//何栋梁

    @PostMapping("/getAllCommdities")
    public Result<?> getAllCommodities(){
        LambdaQueryWrapper<CommodityEntity> qurery = new LambdaQueryWrapper<>();
        qurery.like(CommodityEntity::getName,"");
        List<CommodityEntity> commodityEntities = commodityMapper.selectList(qurery);
        return Result.success(commodityEntities);
    }

    @GetMapping("/getById/{id}")
    public Result<?> getById(@PathVariable String id){
        LambdaQueryWrapper<CommodityEntity> query = new LambdaQueryWrapper<>();
        query.eq(CommodityEntity::getId, id);
        CommodityEntity commodityEntity = commodityMapper.selectOne(query);
        return Result.success(commodityEntity);
    }

    @PostMapping("/getCommdityByName/{name}")
    public Result<?> getCommodityByName(@PathVariable String name){
        LambdaQueryWrapper<CommodityEntity> query = new LambdaQueryWrapper<>();
        query.like(CommodityEntity::getName, name);
        List<CommodityEntity> commodityEntities = commodityMapper.selectList(query);
        return Result.success(commodityEntities);
    }
//何栋梁

}

