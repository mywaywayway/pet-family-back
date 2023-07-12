package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.views.ComGoodsView;
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
 * @since 2023-07-10 18:51:02
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


}

