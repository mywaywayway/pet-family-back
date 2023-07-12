package com.pet.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.pro.entity.views.ComGoodsView;
import org.apache.ibatis.annotations.Mapper;

/**
* @author YehWang
* @description 针对表【com_goods】的数据库操作Mapper
* @createDate 2023-07-11 11:33:45
* @Entity com.pet.pro.entity.ComGoods
*/
@Mapper
public interface ComGoodsMapper extends BaseMapper<ComGoodsView> {

}




