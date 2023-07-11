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
 * 商家信息
 * </p>
 *
 * @author My-way
 * @since 2023-07-10 18:51:02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("shop")
@ApiModel(value = "ShopEntity对象", description = "商家信息")
public class ShopEntity {

    @ApiModelProperty("商家id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("商家名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("商家介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("商家地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("商家id")
    @TableField("merchant_id")
    private Integer merchantId;

    @ApiModelProperty("商家头像")
    @TableField("avatar")
    private String avatar;

}
