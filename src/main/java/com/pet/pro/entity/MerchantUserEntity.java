package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 商家用户
 * @TableName merchant_user
 */
@TableName(value ="merchant_user")
@Data
public class MerchantUserEntity implements Serializable {
    /**
     * 商家用户编号
     */
    @ApiModelProperty("商家用户编号")
    @TableId(value = "merchant_user_ud", type = IdType.AUTO)
    private Integer merchantUserUd;

    /**
     * 商家名称
     */
    @ApiModelProperty("商家名称")
    @TableField("`merchant_name`")
    private String merchantName;

    /**
     * 商家地址
     */
    @ApiModelProperty("商家地址")
    @TableField("`merchant_address`")
    private String merchantAddress;

    /**
     * 登录编号
     */
    @ApiModelProperty("登录编号")
    @TableField("login_id")
    private Integer loginId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
