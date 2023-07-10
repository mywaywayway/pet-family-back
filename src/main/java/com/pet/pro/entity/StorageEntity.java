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
 * 库存信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 17:35:14
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("storage")
@ApiModel(value = "StorageEntity对象", description = "库存信息")
public class StorageEntity {

    @ApiModelProperty("仓库id")
    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private Integer warehouseId;

    @ApiModelProperty("商品id")
    @TableId(value = "commodity_id", type = IdType.AUTO)
    private Integer commodityId;

    @ApiModelProperty("库存数量")
    @TableField("num")
    private Integer num;


}
