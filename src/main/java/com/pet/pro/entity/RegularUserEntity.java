package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 普通用户
 * @TableName regular_user
 */
@TableName(value ="regular_user")
@Data
public class RegularUserEntity implements Serializable {
    /**
     * 普通用户编号
     */
    @TableId
    private Integer regular_user_id;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 登录编号
     */
    private Integer login_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}