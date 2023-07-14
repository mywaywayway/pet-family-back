package com.pet.pro.service;

import com.pet.pro.entity.DTO.MerchantUser;
import com.pet.pro.entity.MerchantUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author YehWang
* @description 针对表【merchant_user(商家用户)】的数据库操作Service
* @createDate 2023-07-11 17:36:38
*/
public interface MerchantUserEntityService extends IService<MerchantUserEntity> {

    /**
     * 根据用户id查询商家用户信息
     * @param id 商家用户id
     *           @return 用户信息
     * @see com.pet.pro.service.impl.MerchantUserEntityServiceImpl#selectMerchantUserByMerchantId(Integer)
     */
    MerchantUser selectMerchantUserByMerchantId(Integer id);
}
