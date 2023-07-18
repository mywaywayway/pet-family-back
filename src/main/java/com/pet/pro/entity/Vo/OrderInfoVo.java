package com.pet.pro.entity.Vo;

import com.pet.pro.entity.OrderGoodsEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderInfoVo {
    private OrderGoodsEntity orderGoodsEntity;
    @ApiModelProperty("商品名称")
    private String name;
    @ApiModelProperty("商品图片")
    private String photo;
    @ApiModelProperty("商家名称")
    private String shopName;
}
