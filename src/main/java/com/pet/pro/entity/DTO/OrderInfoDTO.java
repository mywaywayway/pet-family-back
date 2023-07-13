package com.pet.pro.entity.DTO;

import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.entity.OrderGoodsEntity;
import com.pet.pro.entity.Vo.OrderInfoVo;
import lombok.Data;

import java.util.List;

@Data
public class OrderInfoDTO {
    private OrderFormEntity orderFormEntity;
    private List<OrderInfoVo> list;
}
