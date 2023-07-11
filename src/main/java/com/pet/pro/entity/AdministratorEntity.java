package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 管理员
 * @TableName administrator
 */
@TableName(value ="administrator")
@Data
public class AdministratorEntity implements Serializable {
    /**
     * 管理员编号
     */
    @ApiModelProperty("管理员编号")
    @TableId(value = "administrator_id", type = IdType.AUTO)
    private Integer administratorId;


    /**
     * 用户权限
     */
    @ApiModelProperty("用户权限")
    @TableField("`user_rights`")
    private String userRights;

    /**
     * 登录编号
     */
    @ApiModelProperty("登录编号")
    @TableField("login_id")
    private Integer loginId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
