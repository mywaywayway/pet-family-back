package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.pet.pro.entity.DTO.MerchantUser;
import com.pet.pro.entity.LoginEntity;
import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.mapper.MerchantUserEntityMapper;
import com.pet.pro.service.MerchantUserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YehWang
 * @description 针对表【merchant_user(商家用户)】的数据库操作Service实现
 * @createDate 2023-07-11 17:36:38
 */
@Service
public class MerchantUserEntityServiceImpl extends ServiceImpl<MerchantUserEntityMapper, MerchantUserEntity>
        implements MerchantUserEntityService {

    private MerchantUserEntityMapper merchantUserMapper;

    @Autowired
    public void setMerchantUserEntityMapper(MerchantUserEntityMapper merchantUserEntityMapper) {
        this.merchantUserMapper = merchantUserEntityMapper;
    }

    @Override
    public MerchantUser selectMerchantUserByMerchantId(Integer id) {
        MPJLambdaWrapper<MerchantUserEntity> queryWrapper = new MPJLambdaWrapper<MerchantUserEntity>()
                .selectAll(MerchantUserEntity.class)
                .eq(MerchantUserEntity::getMerchantUserId, id)
                .select(LoginEntity::getUsername, LoginEntity::getPassword, LoginEntity::getGender, LoginEntity::getAvatar, LoginEntity::getPhone, LoginEntity::getEmail)
                .leftJoin(LoginEntity.class, LoginEntity::getLoginId, MerchantUserEntity::getLoginId);

        return merchantUserMapper.selectJoinOne(MerchantUser.class, queryWrapper);
    }
}




