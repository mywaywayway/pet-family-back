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
 * 商家用户
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("merchant_user")
@ApiModel(value = "MerchantUserEntity对象", description = "商家用户")
public class MerchantUserEntity {

    @ApiModelProperty("商家用户编号")
    @TableId(value = "merchant_user_id", type = IdType.AUTO)
    private Integer merchantUserId;

    @ApiModelProperty("商家名称")
    @TableField("merchant_name")
    private String merchantName;

    @ApiModelProperty("商家地址")
    @TableField("merchant_address")
    private String merchantAddress;

    @ApiModelProperty("登录编号")
    @TableField("login_id")
    private Integer loginId;


}
