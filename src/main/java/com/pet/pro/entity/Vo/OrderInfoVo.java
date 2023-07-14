package com.pet.pro.entity.Vo;

import com.pet.pro.entity.OrderGoodsEntity;
import lombok.Data;

@Data
public class OrderInfoVo {
    private OrderGoodsEntity orderGoodsEntity;
    private String name;
}
