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
 * 管理员
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("administrator")
@ApiModel(value = "AdministratorEntity对象", description = "管理员")
public class AdministratorEntity {

    @ApiModelProperty("管理员编号")
    @TableId(value = "administrator_id", type = IdType.AUTO)
    private Integer administratorId;

    @ApiModelProperty("用户权限")
    @TableField("user_rights")
    private String userRights;

    @ApiModelProperty("登录编号")
    @TableField("login_id")
    private Integer loginId;


}
