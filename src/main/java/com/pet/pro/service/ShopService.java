package com.pet.pro.service;

import com.pet.pro.entity.ShopEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商店信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface ShopService extends IService<ShopEntity> {


    List<ShopEntity> getShopByMerchantId(int merchantId);
}
