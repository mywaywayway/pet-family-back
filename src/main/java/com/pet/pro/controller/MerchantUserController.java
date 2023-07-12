package com.pet.pro.controller;


import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.service.MerchantUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 商家用户 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/merchant-user-entity")
public class MerchantUserController {

    MerchantUserService merchantUserService;
    @Autowired
    public void setMerchantUserService(MerchantUserService merchantUserService){
        this.merchantUserService = merchantUserService;
    }


    /** DoubleHong
     * 获取所有商家用户
     * @return 所有商家用户
     */
    @GetMapping("/getAllMerchantUser")
    public List<MerchantUserEntity> getAllMerchantUser(){
        return merchantUserService.getAllMerchantUser();
    }

}

