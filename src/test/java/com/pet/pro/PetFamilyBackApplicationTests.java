package com.pet.pro;

import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.ComGoodsMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PetFamilyBackApplicationTests {

    @Autowired
    private ComGoodsMapper comGoodsMapper;

    @Test
    void contextLoads() {
        System.out.println(comGoodsMapper.selectByShopId(1));
    }

}
