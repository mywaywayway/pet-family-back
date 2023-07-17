package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.mapper.ShopMapper;
import com.pet.pro.service.ShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商店信息 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, ShopEntity> implements ShopService {


    ShopMapper shopMapper;
    @Autowired
    public void setShopMapper(ShopMapper shopMapper){
        this.shopMapper = shopMapper;
    }

    @Override
    public List<ShopEntity> getShopByMerchantId(int merchantId) {
        return shopMapper.selectList(new QueryWrapper<ShopEntity>().eq("merchant_id",merchantId));
    }

    @Override
    public Result<?> getShopById(int shopId) {
        return Result.success(shopMapper.selectById(shopId),"success");
    }
}
