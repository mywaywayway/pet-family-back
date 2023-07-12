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
 * 商品信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("commodity")
@ApiModel(value = "CommodityEntity对象", description = "商品信息")
public class CommodityEntity {

    @ApiModelProperty("商品id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("类别id")
    @TableField("type_id")
    private Integer typeId;

    @ApiModelProperty("品牌id")
    @TableField("brand_id")
    private Integer brandId;

    @ApiModelProperty("商品名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("商品图片")
    @TableField("photo")
    private String photo;

    @ApiModelProperty("商品介绍")
    @TableField("introduce")
    private String introduce;

    @ApiModelProperty("商品价格")
    @TableField("price")
    private Double price;

    @ApiModelProperty("销量")
    @TableField("sale_volume")
    private Integer saleVolume;

    @ApiModelProperty("商品状态")
    @TableField("state")
    private String state;

    @ApiModelProperty("商家id")
    @TableField("shop_id")
    private Integer shopId;


}
