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
 * 商店信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("shop")
@ApiModel(value = "ShopEntity对象", description = "商店信息")
public class ShopEntity {

    @ApiModelProperty("商店id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商店名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("商店介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("商家用户编号")
    @TableField("merchant_id")
    private Integer merchantId;

    @ApiModelProperty("商店的地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("商店的头像")
    @TableField("avatar")
    private String avatar;


}
