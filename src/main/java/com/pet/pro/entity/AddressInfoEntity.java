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
 * 地址信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 17:35:14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("address_info")
@ApiModel(value = "AddressInfoEntity对象", description = "地址信息")
public class AddressInfoEntity {

    @ApiModelProperty("地址编号")
    @TableId(value = "address_id", type = IdType.AUTO)
    private Integer addressId;

    @ApiModelProperty("用户编号")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("联系人")
    @TableField("linkman")
    private String linkman;

    @ApiModelProperty("地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("联系人电话")
    @TableField("linkman_phone")
    private String linkmanPhone;

    @ApiModelProperty("具体地址")
    @TableField("detail_address")
    private String detailAddress;


}
