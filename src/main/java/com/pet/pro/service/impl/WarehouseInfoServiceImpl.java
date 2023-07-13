package com.pet.pro.service.impl;

import com.pet.pro.entity.WarehouseInfoEntity;
import com.pet.pro.mapper.WarehouseInfoMapper;
import com.pet.pro.service.WarehouseInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 仓库信息 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class WarehouseInfoServiceImpl extends ServiceImpl<WarehouseInfoMapper, WarehouseInfoEntity> implements WarehouseInfoService {

    /**
     * 得到所有的仓库信息
     * @return 仓库信息列表
     * @see com.pet.pro.service.WarehouseInfoService#selectAllWarehouseInfo()
     */
    public List<WarehouseInfoEntity> selectAllWarehouseInfo(){
        return baseMapper.selectList(null);
    }

}
