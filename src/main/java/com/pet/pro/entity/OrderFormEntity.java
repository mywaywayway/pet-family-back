package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_form")
@ApiModel(value = "OrderFormEntity对象", description = "")
public class OrderFormEntity {

    @ApiModelProperty("订单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("交易时间")
    @TableField("`time`")
    private LocalDateTime time;

    @ApiModelProperty("交易地址")
    @TableField("address")
    private String address;

    @ApiModelProperty("联系人电话")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("交易总价")
    @TableField("total_price")
    private Double totalPrice;

    @ApiModelProperty("联系人姓名")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("订单状态")
    @TableField("state")
    private String state;

    @ApiModelProperty("用户编号")
    @TableField("person_id")
    private Integer personId;


}
