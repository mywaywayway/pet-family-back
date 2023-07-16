package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:08:12
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("order_total_info")
@ApiModel(value = "OrderFormEntity对象", description = "")
public class OrderTotalInfoViewEntity {

    @ApiModelProperty("交易时间")
    private LocalDateTime time;

    @ApiModelProperty("交易地址")
    private String address;

    @ApiModelProperty("联系人电话")
    private String phone;

    @ApiModelProperty("交易总价")
    private Double totalPrice;

    @ApiModelProperty("联系人姓名")
    private String name;

    @ApiModelProperty("订单状态")
    private String state;

    @ApiModelProperty("用户编号")
    private Integer personId;

    @ApiModelProperty("订单id")
    @TableField("id")
    private Integer orderId;

    @ApiModelProperty("物品id")
    private Integer commodityId;

    @ApiModelProperty("交易数量")
    private Integer num;


}
