package com.pet.pro.service;

import com.pet.pro.entity.CommodityEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
public interface CommodityService extends IService<CommodityEntity> {

    /**
     * 添加商品
     * @param commodityEntity  增加的商品实体信息
     * @return  1：添加成功  0：添加失败
     * @see com.pet.pro.service.impl.CommodityServiceImpl#addCommodity(CommodityEntity)
     */
    int addCommodity(CommodityEntity commodityEntity);

    /**
     * 根据商店id查询商品
     * @param shopId 商店id
     * @return  商品列表
     * @see com.pet.pro.service.impl.CommodityServiceImpl#selectCommodityByShopId(int)
     */
    List<CommodityEntity> selectCommodityByShopId(int shopId);

}
