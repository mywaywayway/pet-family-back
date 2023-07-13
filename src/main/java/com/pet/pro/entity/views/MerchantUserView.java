package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName merchant_user_view
 */
@TableName(value ="merchant_user_view")
@Data
public class MerchantUserView implements Serializable {
    /**
     * 商家用户编号
     */
    @TableField(value = "merchant_user_id")
    private Integer merchantUserId;

    /**
     * 商家名称
     */
    @TableField(value = "merchant_name")
    private String merchantName;

    /**
     * 商家地址
     */
    @TableField(value = "merchant_address")
    private String merchantAddress;

    /**
     * 登录编号
     */
    @TableField(value = "login_id")
    private Integer loginId;

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
