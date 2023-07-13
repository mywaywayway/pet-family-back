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
 * 登录用户
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("login")
@ApiModel(value = "LoginEntity对象", description = "登录用户")
public class LoginEntity {

    @ApiModelProperty("登录编号")
    @TableId(value = "login_id", type = IdType.AUTO)
    private Integer loginId;

    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty("密码")
    @TableField("`password`")
    private String password;

    @ApiModelProperty("性别")
    @TableField("gender")
    private String gender;

    @ApiModelProperty("头像")
    @TableField("avatar")
    private String avatar;

    @ApiModelProperty("电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("等级")
    @TableField("grade")
    private String grade;


}
