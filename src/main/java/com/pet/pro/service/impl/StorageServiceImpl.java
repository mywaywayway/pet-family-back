package com.pet.pro.service.impl;

import com.pet.pro.entity.StorageEntity;
import com.pet.pro.mapper.StorageMapper;
import com.pet.pro.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * <p>
 * 库存信息 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, StorageEntity> implements StorageService {

    /**
     * 添加库存信息
      * @param storageEntity 库存实体
     * @return 1?0 1：添加成功 0：添加失败
     * @see com.pet.pro.service.StorageService#addStorage(StorageEntity)
     */
    public int addStorage(StorageEntity storageEntity) {
        UUID uuid= UUID.randomUUID();
        storageEntity.setStorageId(uuid.toString());
        return baseMapper.insert(storageEntity);
    }
}
