package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.service.CommodityService;
import com.pet.pro.service.impl.CommodityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private CommodityService commodityService;

    private CommodityServiceImpl commodityServiceImpl;

    @Autowired
    public void setCommodityService(CommodityService commodityService) {
        this.commodityService = commodityService;
    }

    @Autowired
    public void setCommodityServiceImpl(CommodityServiceImpl commodityServiceImpl) {
        this.commodityServiceImpl = commodityServiceImpl;
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


}

