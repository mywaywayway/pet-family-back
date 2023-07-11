package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
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
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 交易时间
     */
    @TableField("`time`")
    private Date time;

    /**
     * 交易地址
     */
    @TableField("`address`")
    private String address;

    /**
     * 联系人电话
     */
    @TableField("`phone`")
    private String phone;

    /**
     * 交易总价
     */
    @TableField("total_price")
    private Double totalPrice;


    /**
     * 联系人姓名
     */
    @TableField("`name`")
    private String name;

    /**
     * 订单状态
     */
    @TableField("`state`")
    private String state;

    /**
     * 用户编号
     */
    @TableField("person_id")
    private Integer personId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
