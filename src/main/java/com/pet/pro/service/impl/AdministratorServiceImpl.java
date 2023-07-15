package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.AdministratorEntity;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.AdministratorMapper;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.mapper.ShopMapper;
import com.pet.pro.service.AdministratorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, AdministratorEntity> implements AdministratorService {

    CommodityMapper commodityMapper;
    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper){
        this.commodityMapper = commodityMapper;
    }

    ComGoodsMapper comGoodsMapper;
    @Autowired
    public void setComGoodsMapper(ComGoodsMapper comGoodsMapper){
        this.comGoodsMapper = comGoodsMapper;
    }

    ShopMapper shopMapper;
    @Autowired
    public void setShopMapper(ShopMapper shopMapper){
        this.shopMapper = shopMapper;
    }

    /**
     * @author DoubleHong;
     *  获取所有商品并返回该店铺下新的商品信息
     * @param commodityId 商品id
     * @return 所有商品视频
     */
    @Override
    public Result<List<ComGoodsView>> takeOffCommodityById( int commodityId,int currentShopId){
        //获取该商品
        CommodityEntity commodityEntity = commodityMapper.selectById(commodityId);
        //下架该商品
        commodityEntity.setState("未上架");
        //更新该商品
        commodityMapper.updateById(commodityEntity);
        return Result.success(comGoodsMapper.selectList(new QueryWrapper<ComGoodsView>().eq("shop_id",currentShopId)));
    }


    /**
     * @author DoubleHong
     * 获取所有店铺并返回该商家下新的店铺信息
     * @param shopId 店铺id
     * @param currentMerchantId 商家id
     * @return 所有店铺信息
     */
    @Override
    public Result<List<ShopEntity>> closeShopById(int shopId, int currentMerchantId) {
        //获取该店铺
        ShopEntity shopEntity = shopMapper.selectById(shopId);
        //关闭该店铺
        shopEntity.setShopStatus("歇业中");
        //更新该店铺
        shopMapper.updateById(shopEntity);
        return Result.success(shopMapper.selectList(new QueryWrapper<ShopEntity>().eq("merchant_id",currentMerchantId)));
    }

}
