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
 * 登录
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("login")
@ApiModel(value = "LoginEntity对象", description = "登录")
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
