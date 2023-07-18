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
 * 购物车
 * </p>
 *
 * @author  My-way
 * @since 2023-07-16 11:05:57
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("shopping_cart")
@ApiModel(value = "ShoppingCartEntity对象", description = "购物车")
public class ShoppingCartEntity {

    @ApiModelProperty("购物车编号")
    @TableId(value = "shopping_cart_id", type = IdType.AUTO)
    private Integer shoppingCartId;

    @ApiModelProperty("普通用户编号")
    @TableField("regular_user_id")
    private Integer regularUserId;

    @ApiModelProperty("商品编号")
    @TableField("commodity_id")
    private Integer commodityId;

    @ApiModelProperty("商品数量")
    @TableField("commodity_number")
    private Integer commodityNumber;


}
