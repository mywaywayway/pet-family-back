package com.pet.pro.service;

import com.pet.pro.entity.CommodityEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 商品信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
public interface CommodityService extends IService<CommodityEntity> {

    /**
     * 添加商品
     * @param commodityEntity  增加的商品实体信息
     * @return  1：添加成功  0：添加失败
     * @see com.pet.pro.service.impl.CommodityServiceImpl#addCommodity(CommodityEntity)
     */
    int addCommodity(CommodityEntity commodityEntity);

}
