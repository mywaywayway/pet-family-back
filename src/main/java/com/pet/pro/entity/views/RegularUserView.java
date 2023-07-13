package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName regular_user_view
 */
@Data
@TableName(value ="regular_user_view")
public class RegularUserView implements Serializable {
    /**
     * 普通用户编号
     */
    @TableField(value = "regular_user_id")
    private Integer regular_user_id;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private String birthday;

    /**
     * 登录编号
     */
    @TableField(value = "login_id")
    private Integer login_id;

    /**
     * 用户姓名
     */
    @TableField(value = "regular_name")
    private String regular_name;

    /**
     * 昵称
     */
    @TableField(value = "nickname")
    private String nickname;

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

}