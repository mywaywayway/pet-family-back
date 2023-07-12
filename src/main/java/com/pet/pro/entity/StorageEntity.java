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
 * @since 2023-07-11 20:16:25
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("storage")
@ApiModel(value = "StorageEntity对象", description = "库存信息")
public class StorageEntity {

    @ApiModelProperty("库存id")
    @TableId(value = "storage_id", type = IdType.AUTO)
    private String storageId;

    @ApiModelProperty("仓库id")
    @TableField("warehouse_id")
    private Integer warehouseId;

    @ApiModelProperty("商品id")
    @TableField("commodity_id")
    private Integer commodityId;

    @ApiModelProperty("库存数量")
    @TableField("quantity")
    private Double quantity;


}
