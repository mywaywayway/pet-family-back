package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.CommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 商品信息 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, CommodityEntity> implements CommodityService {
 @Autowired
   CommodityMapper commodityMapper;

   /**
     * 添加商品
     * @param commodityEntity  增加的商品实体信息
     * @return  1：添加成功  0：添加失败
    * @see com.pet.pro.service.CommodityService#addCommodity(CommodityEntity)
     */
    @Override
    public int addCommodity(CommodityEntity commodityEntity) {
        return baseMapper.insert(commodityEntity) ;
    }

    /**
     * 根据商店id查询商品
     * @param shopId 商店id
     * @return  商品列表
     * @see com.pet.pro.service.CommodityService#selectCommodityByShopId(int)
     */
    @Override
    public List<CommodityEntity> selectCommodityByShopId(int shopId) {
        return commodityMapper.selectList(Wrappers.<CommodityEntity>lambdaQuery().eq(CommodityEntity::getShopId,shopId));
    }
}
