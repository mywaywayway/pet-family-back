package com.pet.pro.service;

import com.pet.pro.entity.CommodityEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.pro.entity.DTO.ComCount;

import java.util.List;

import java.util.List;

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

    /**
     * 根据商店id进行商品种类查询
     * @param shopId    商店id
     *                  @return 商品种类
     *                  @see com.pet.pro.service.impl.CommodityServiceImpl#getCommodityTypeByShopId(int)
     */
    List<ComCount> getCommodityTypeByShopId(int shopId);
    /**
     * 根据商店id查询商品
     * @param shopId 商店id
     * @return  商品列表
     * @see com.pet.pro.service.impl.CommodityServiceImpl#selectCommodityByShopId(int)
     */
    List<CommodityEntity> selectCommodityByShopId(int shopId);

    /**
     * 根据商品id修改商品信息
     * @param commodityEntity 商品实体
     * @return 1?0 1：更新成功 0：更新失败
     * @see com.pet.pro.service.impl.CommodityServiceImpl#updateCommodityById(CommodityEntity)
     */
     int   updateCommodityById(CommodityEntity commodityEntity);

     /**
      * 根据商品id查询商品信息
      * @param commodityId 商品id
      * @return 商品列表
      * @see com.pet.pro.service.impl.CommodityServiceImpl#selectCommodityById(int)
      */

     CommodityEntity selectCommodityById(int commodityId);

    /**
     * 根据商品id删除商品
     * @param commodityId 商品id
     * @return 1?0 1：删除成功 0：删除失败
     * @see com.pet.pro.service.impl.CommodityServiceImpl#deleteCommodityById(int)
     */
    int deleteCommodityById(int commodityId);
}
