package com.pet.pro.service;

import com.pet.pro.entity.MerchantUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商家用户 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
public interface MerchantUserService extends IService<MerchantUserEntity> {


    List<MerchantUserEntity> getAllMerchantUser();

}
