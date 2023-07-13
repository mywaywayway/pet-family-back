package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @TableName user_total_info_view
 */
@TableName(value ="user_total_info_view")
@Data
public class UserTotalInfoView implements Serializable {
    /**
     * 地址编号
     */
    @TableField(value = "address_id")
    private Integer address_id;

    /**
     * 用户编号
     */
    @TableField(value = "user_id")
    private Integer user_id;

    /**
     * 联系人
     */
    @TableField(value = "linkman")
    private String linkman;

    /**
     * 地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 联系人电话
     */
    @TableField(value = "linkman_phone")
    private String linkman_phone;

    /**
     * 具体地址
     */
    @TableField(value = "detail_address")
    private String detail_address;

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

    /**
     * 等级 1:regular 2:merchant 3:admin
     */
    @TableField(value = "grade")
    private String grade;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private String birthday;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
