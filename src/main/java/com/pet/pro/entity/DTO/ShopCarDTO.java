package com.pet.pro.entity.DTO;

import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.entity.OrderGoodsEntity;
import lombok.Data;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/17
 */
@Data
public class ShopCarDTO {
    private OrderFormEntity orderFormEntity;
    private List<OrderGoodsEntity> list;
}
