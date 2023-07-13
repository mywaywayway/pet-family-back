package com.pet.pro.service;

import com.pet.pro.entity.StorageEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 库存信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface StorageService extends IService<StorageEntity> {
    /**
     * 添加库存信息
     * @param storageEntity 库存实体
     * @return 1?0 1：添加成功 0：添加失败
     * @see com.pet.pro.service.impl.StorageServiceImpl#addStorage(StorageEntity)
     */
    int addStorage(StorageEntity storageEntity);

}
