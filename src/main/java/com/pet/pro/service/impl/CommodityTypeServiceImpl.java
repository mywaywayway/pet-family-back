package com.pet.pro.service.impl;

import com.pet.pro.entity.CommodityTypeEntity;
import com.pet.pro.mapper.CommodityTypeMapper;
import com.pet.pro.service.CommodityTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品类别 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class CommodityTypeServiceImpl extends ServiceImpl<CommodityTypeMapper, CommodityTypeEntity> implements CommodityTypeService {



    @Override

    public List<CommodityTypeEntity> selectAllCommodityType() {
        return baseMapper.selectList(null);
    }
}
