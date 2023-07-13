package com.pet.pro;

import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.MerchantUserEntityMapper;
import com.pet.pro.service.impl.CommodityServiceImpl;
import com.pet.pro.service.impl.MerchantUserEntityServiceImpl;
import com.pet.pro.service.impl.RegularUserEntityServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetFamilyBackApplicationTests {

    @Autowired
    private ComGoodsMapper comGoodsMapper;

    @Autowired
    private RegularUserEntityServiceImpl regularUserEntityService;

    @Resource
    private MerchantUserEntityMapper MerchantUserEntityMapper;

    @Resource
    private MerchantUserEntityServiceImpl merchantUserEntityService;

    @Resource
    CommodityServiceImpl commodityService;

    @Test
    void contextLoads() {
        System.out.println(commodityService.getCommodityTypeByShopId(1));
    }

}
