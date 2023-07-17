package com.pet.pro.service;

import com.pet.pro.Result;
import com.pet.pro.entity.AdministratorEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.entity.views.AdminUserView;
import com.pet.pro.entity.views.ComGoodsView;

import java.util.List;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface AdministratorService extends IService<AdministratorEntity> {


    //商品下架
    Result<List<ComGoodsView>> takeOffCommodityById(int commodityId,int currentShopId);

    //关闭店铺
    Result<List<ShopEntity>> closeShopById(int shopId,int currentMerchantId);

    Result<?> updateAdmin(AdminUserView adminUserView);
}
