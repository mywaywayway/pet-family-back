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
@TableName("comments_order_view")
@ApiModel(value = "OrderFormEntity对象", description = "")
public class CommentsOrderFormEntity {

    @ApiModelProperty("订单id")
    private Integer orderId;

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

    @ApiModelProperty("评价id")
    private Integer commentsId;

    @ApiModelProperty("评价内容")
    private String commentsContent;

    @ApiModelProperty("评价照片")
    private String commentsPhoto;

    @ApiModelProperty("商品id")
    private Integer commodityId;

    @ApiModelProperty("店家回复")
    private String reply;

    private String regularName;

    @ApiModelProperty("昵称")
    private String nickname;

    @ApiModelProperty("评分等级")
    private Integer grade;


}
