package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 商店信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:08:12
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("comments")
@ApiModel(value = "Comments对象", description = "评价信息")
public class CommentsEntity {

    @ApiModelProperty("评价id")
    @TableId(value = "comments_id", type = IdType.AUTO)
    private Integer commentsId;

    @ApiModelProperty("评价内容")
    @TableField("`comments_content`")
    private String commentsContent;

    @ApiModelProperty("评价照片")
    @TableField("comments_photo")
    private String commentsPhoto;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty("商品id")
    @TableField("commodity_id")
    private Integer commodityId;

    @ApiModelProperty("店家回复")
    @TableField("reply")
    private String reply;

    @ApiModelProperty("评分等级")
    @TableField("grade")
    private Integer grade;



}
