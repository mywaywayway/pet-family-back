package com.pet.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.pro.entity.views.ComGoodsView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author YehWang
* @description 针对表【com_goods】的数据库操作Mapper
* @createDate 2023-07-11 11:33:45
* @Entity com.pet.pro.entity.ComGoods
*/
@Mapper
public interface ComGoodsMapper extends BaseMapper<ComGoodsView> {

    /**
     * 根据商店id查询商品信息
     * @param shopId 商店id
     * @return 商品信息
     */
    @Select("select * from com_goods where shop_id = #{shopId}")
    List<ComGoodsView> selectByShopId(Integer shopId);
}




