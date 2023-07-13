package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.DTO.ComCount;
import com.pet.pro.mapper.ComTypeCountMapper;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.CommodityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    private CommodityMapper commodityMapper;
    private ComTypeCountMapper comTypeCountMapper;
    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper) {
        this.commodityMapper = commodityMapper;
    }
    @Autowired
    public void setComTypeCountMapper(ComTypeCountMapper comTypeCountMapper) {
        this.comTypeCountMapper = comTypeCountMapper;
    }

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
     * 根据商店id进行商品种类查询
     * @param shopId    商店id
     *                  @return 商品种类
     *                  @see com.pet.pro.service.CommodityService#getCommodityTypeByShopId(int)
     */
    @Override
    public List<ComCount> getCommodityTypeByShopId(int shopId) {
        QueryWrapper<ComCount> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("shop_id",shopId);
        return comTypeCountMapper.selectList(queryWrapper);
    }
}
