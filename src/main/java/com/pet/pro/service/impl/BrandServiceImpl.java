package com.pet.pro.service.impl;

import com.pet.pro.entity.BrandEntity;
import com.pet.pro.mapper.BrandMapper;
import com.pet.pro.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, BrandEntity> implements BrandService {


    @Override
    public List<BrandEntity> GetAllBrand(){
        return baseMapper.selectList(null);
    }
}
