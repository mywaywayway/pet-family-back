package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName admin_user_view
 */
@TableName(value ="admin_user_view")
@Data
public class AdminUserView implements Serializable {
    /**
     * 管理员编号
     */
    @TableField(value = "administrator_id")
    private Integer administrator_id;

    /**
     * 用户权限
     */
    @TableField(value = "user_rights")
    private String user_rights;

    /**
     * 登录编号
     */
    @TableField(value = "login_id")
    private Integer login_id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
