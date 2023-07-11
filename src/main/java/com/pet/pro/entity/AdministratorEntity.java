package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
    @TableId
    private Integer administrator_id;

    /**
     * 用户权限
     */
    private String user_rights;

    /**
     * 登录编号
     */
    private Integer login_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}