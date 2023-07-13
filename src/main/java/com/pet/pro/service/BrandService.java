package com.pet.pro.service;

import com.pet.pro.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface BrandService extends IService<BrandEntity> {

    /**
     * 搜索所有的品牌
     * @return 品牌列表
     * @see com.pet.pro.service.impl.BrandServiceImpl#GetAllBrand()
     */
    List<BrandEntity> GetAllBrand();
}
