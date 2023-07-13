package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.service.ComGoodsService;
import com.pet.pro.service.ComGoodsService;
import com.pet.pro.mapper.ComGoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YehWang
 * @description 针对表【com_goods】的数据库操作Service实现
 * @createDate 2023-07-11 11:33:45
 */
@Service
public class ComGoodsServiceImpl extends ServiceImpl<ComGoodsMapper, ComGoodsView>
        implements ComGoodsService {

    private ComGoodsMapper comGoodsMapper;

    @Autowired
    public void setComGoodsMapper(ComGoodsMapper comGoodsMapper) {
        this.comGoodsMapper = comGoodsMapper;
    }

    @Override
    public List<ComGoodsView> getComGoodsListByShopId(int shopId) {
        return comGoodsMapper.selectList(Wrappers.<ComGoodsView>lambdaQuery().eq(ComGoodsView::getShopId, shopId));
    }

//    @Override
//    public List<ComGoodsView> getComGoodsByShopId(int shopId) {
//        return comGoodsMapper.selectList(Wrappers.<ComGoodsView>lambdaQuery().eq(ComGoodsView::getShopId, shopId));
//    }
}




