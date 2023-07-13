package com.pet.pro.service;

import com.pet.pro.entity.CommodityTypeEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品类别 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface CommodityTypeService extends IService<CommodityTypeEntity> {

    /**
     *  搜索所有的商品类型
     * @return 商品类型列表
     * @see com.pet.pro.service.impl.CommodityTypeServiceImpl#selectAllCommodityType()
     */

    List<CommodityTypeEntity> selectAllCommodityType();
}
