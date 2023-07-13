package com.pet.pro.mapper;

import com.pet.pro.entity.ShopEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 商店信息 Mapper 接口
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Mapper
public interface ShopMapper extends BaseMapper<ShopEntity> {

    /**
     * 根据商家id查询店铺信息
     * @param id 商家id
     * @return 店铺信息
     */
    @Select("select * from pet_shop.shop where merchant_id = #{id}")
    List<ShopEntity> selectShopByMerchantId(Integer id);
}
