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
 * 
 * </p>
 *
 * @author  My-way
 * @since 2023-07-17 14:11:59
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("comments")
@ApiModel(value = "CommentsEntity对象", description = "")
public class CommentsEntity {

    @ApiModelProperty("留言id")
    @TableId(value = "comments_id", type = IdType.AUTO)
    private Integer commentsId;

    @ApiModelProperty("留言内容")
    @TableField("comments_content")
    private String commentsContent;

    @ApiModelProperty("留言照片")
    @TableField("comments_photo")
    private String commentsPhoto;

    @ApiModelProperty("订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty("商品id")
    @TableField("commodity_id")
    private Integer commodityId;

    @ApiModelProperty("评分等级")
    @TableField("grade")
    private Integer grade;

    @ApiModelProperty("商家回复")
    @TableField("reply")
    private String reply;


}
