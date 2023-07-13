package com.pet.pro.service.impl;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/13
 */
class CommodityServiceImplTest {

    @Resource
    CommodityServiceImpl commodityService;

    @Test
    void getCommodityTypeByShopId() {
        System.out.println(commodityService.getCommodityTypeByShopId(1));
    }
}
