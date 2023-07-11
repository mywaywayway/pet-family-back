package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.service.impl.ComGoodsServiceImpl;
import com.pet.pro.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author My-way
 * @since 2023-07-10 18:51:02
 */
@RestController
@RequestMapping("/commodity-entity")
public class CommodityController {

    private CommodityServiceImpl commodityServiceImpl;

    @Autowired
    public void setCommodityServiceImpl(CommodityServiceImpl commodityServiceImpl) {
        this.commodityServiceImpl = commodityServiceImpl;
    }

    private ComGoodsServiceImpl comGoodsServiceImpl;

    @Autowired
    public void setComGoodsServiceImpl(ComGoodsServiceImpl comGoodsServiceImpl) {
        this.comGoodsServiceImpl = comGoodsServiceImpl;
    }

    /**
     * 添加商品
     *
     * @param commodityEntity 增加的商品实体信息
     * @return Result<?>
     */
    @PostMapping("/addCommodity")
    public Result<?> addCommodity(@RequestBody CommodityEntity commodityEntity) {
        int flag = commodityServiceImpl.addCommodity(commodityEntity);
        if (flag == 1) {
            return Result.success("添加成功");
        } else {
            return Result.fail("添加失败");
        }
    }

    /**
     * 根据商户id查询商户所有商品具体信息
     *
     * @param merchantId 商户id
     * @return Result<?> 商户所有商品具体信息
     */
    @ResponseBody
    @GetMapping("/getCommodityByMerchantId/{merchantId}")
    public Result<?> getCommodityByMerchantId(@PathVariable("merchantId") Integer merchantId) {
        if (merchantId != null) {
            return Result.success(this.comGoodsServiceImpl.getComGoodsListByShopId(merchantId));
        } else {
            return Result.fail("查询条件不能为空");
        }
    }
}

