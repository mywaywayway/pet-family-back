package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.DTO.ComCount;
import com.pet.pro.mapper.ComTypeCountMapper;
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

    /**
     * 根据商品id修改商品信息
     * @param commodityEntity 商品实体
     * @return 1?0 1：更新成功 0：更新失败
     * @see com.pet.pro.service.CommodityService#updateCommodityById(CommodityEntity)
     */
    @Override
    public int updateCommodityById(CommodityEntity commodityEntity) {
        return commodityMapper.updateById(commodityEntity);
    }


    /**
     * 根据商品id查询商品信息
     * @param commodityId 商品id
     * @return 商品列表
     * @see com.pet.pro.service.CommodityService#selectCommodityById(int)
     */
    @Override
    public CommodityEntity selectCommodityById(int commodityId) {
        return commodityMapper.selectById(commodityId);
    }

    /**
     * 根据商品id删除商品
     * @param commodityId 商品id
     * @return 1?0 1：删除成功 0：删除失败
     * @see com.pet.pro.service.CommodityService#deleteCommodityById(int)
     */
    @Override
    public int deleteCommodityById(int commodityId) {
        return commodityMapper.deleteById(commodityId);
    }

}
