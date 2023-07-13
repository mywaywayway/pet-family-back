package com.pet.pro.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.pro.entity.views.ComGoodsView;

import java.util.List;

/**
* @author YehWang
* @description 针对表【com_goods】的数据库操作Service
* @createDate 2023-07-11 11:33:45
*/
public interface ComGoodsService extends IService<ComGoodsView> {


    /**
     * 根据店铺ID获取商品列表
     * @param shopId 店铺ID
     * @return 商品列表
     * @see com.pet.pro.service.impl.ComGoodsServiceImpl#getComGoodsListByShopId(int)
     */
    List<ComGoodsView> getComGoodsListByShopId(int shopId);
    /**
     * 根据视图ID更改视图信息
     * @param  comGoodsView 视图实体
     * @return int 1：更新成功 0：更新失败
     * @see com.pet.pro.service.impl.ComGoodsServiceImpl#updateComGoodById(ComGoodsView)
     */

}
