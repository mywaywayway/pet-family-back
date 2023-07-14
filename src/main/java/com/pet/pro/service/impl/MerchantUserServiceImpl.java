package com.pet.pro.service.impl;

import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.mapper.MerchantUserMapper;
import com.pet.pro.service.MerchantUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商家用户 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Service
public class MerchantUserServiceImpl extends ServiceImpl<MerchantUserMapper, MerchantUserEntity> implements MerchantUserService {


    MerchantUserMapper merchantUserMapper;

    @Autowired
    public void setMerchantUserMapper(MerchantUserMapper merchantUserMapper){
        this.merchantUserMapper = merchantUserMapper;
    }

    @Override
    public List<MerchantUserEntity> getAllMerchantUser() {
        return merchantUserMapper.selectList(null);
    }
}
