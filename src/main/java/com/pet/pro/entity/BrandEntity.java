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
 * 品牌信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("brand")
@ApiModel(value = "BrandEntity对象", description = "品牌信息")
public class BrandEntity {

    @ApiModelProperty("品牌id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("品牌名称")
    @TableField("`name`")
    private String name;

    @ApiModelProperty("品牌介绍")
    @TableField("introduce")
    private String introduce;

    @TableField("brand_avatar_url")
    private String brandAvatarUrl;


}
