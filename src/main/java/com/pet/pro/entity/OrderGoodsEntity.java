package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_goods")
@ApiModel(value = "OrderGoodsEntity对象", description = "")
public class OrderGoodsEntity {

    @ApiModelProperty("交易物品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty("物品id")
    @TableField("commodity_id")
    private Integer commodityId;

    @ApiModelProperty("交易数量")
    @TableField("num")
    private Integer num;

    @ApiModelProperty("交易总价")
    @TableField("total_price")
    private Double totalPrice;


}
