package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName order_form
 */
@TableName(value ="order_form")
@Data
public class OrderFormEntity implements Serializable {
    /**
     * 订单id
     */
    @TableId
    private Integer id;

    /**
     * 交易时间
     */
    private Date time;

    /**
     * 交易地址
     */
    private String address;

    /**
     * 联系人电话
     */
    private String phone;

    /**
     * 交易总价
     */
    private Double total_price;

    /**
     * 联系人姓名
     */
    private String name;

    /**
     * 订单状态
     */
    private String state;

    /**
     * 用户编号
     */
    private Integer person_id;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}