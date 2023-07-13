package com.pet.pro.service;

import com.pet.pro.entity.WarehouseInfoEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 仓库信息 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface WarehouseInfoService extends IService<WarehouseInfoEntity> {

    /**
     * 得到所有的仓库信息
     * @param 空
     * @return  仓库信息列表
     * @see com.pet.pro.service.impl.WarehouseInfoServiceImpl#selectAllWarehouseInfo(WarehouseInfoEntity)
     */
    List<WarehouseInfoEntity> selectAllWarehouseInfo();
}
