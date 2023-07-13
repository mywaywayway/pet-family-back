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
 * 普通用户
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("regular_user")
@ApiModel(value = "RegularUserEntity对象", description = "普通用户")
public class RegularUserEntity {

    @ApiModelProperty("普通用户编号")
    @TableId(value = "regular_user_id", type = IdType.AUTO)
    private Integer regularUserId;

    @ApiModelProperty("生日")
    @TableField("birthday")
    private String birthday;

    @ApiModelProperty("登录编号")
    @TableField("login_id")
    private Integer loginId;


}
