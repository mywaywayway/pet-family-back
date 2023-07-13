package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.mapper.StorageMapper;
import com.pet.pro.service.StorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    private StorageMapper storageMapper;
    @Autowired
    public void setStorageMapper(StorageMapper storageMapper) {
        this.storageMapper = storageMapper;
    }


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

    /**
     * 查询所有库存信息
     * @return List<StorageEntity> 库存实体集合
     * @see com.pet.pro.service.StorageService#selectAllStorage()
     */
    public List<StorageEntity> selectAllStorage() {
        return baseMapper.selectList(null);
    }
    /**
     * 添加库存数量
     * @param storageEntity 库存实体
     * @return 1?0 1：添加成功 0：添加失败
     * @see com.pet.pro.service.StorageService#addStorageQuantity(StorageEntity)
     */
    public int addStorageQuantity(StorageEntity storageEntity) {
        StorageEntity storageEntity1=storageMapper.selectOne(Wrappers.<StorageEntity>lambdaQuery().eq(StorageEntity::getCommodityId,storageEntity.getCommodityId()));
        storageEntity1.setQuantity(storageEntity1.getQuantity()+storageEntity.getQuantity());
        return storageMapper.updateById(storageEntity1);
    }

}
