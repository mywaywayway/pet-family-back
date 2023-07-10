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
 * 仓库信息
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 17:35:15
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("warehouse_info")
@ApiModel(value = "WarehouseInfoEntity对象", description = "仓库信息")
public class WarehouseInfoEntity {

    @ApiModelProperty("仓库编号")
    @TableId(value = "warehouse_id", type = IdType.AUTO)
    private Integer warehouseId;

    @ApiModelProperty("仓库名称")
    @TableField("warehouse_name")
    private String warehouseName;

    @ApiModelProperty("仓库地址")
    @TableField("warehouse_address")
    private String warehouseAddress;

    @ApiModelProperty("仓库负责人")
    @TableField("warehouse_principal")
    private String warehousePrincipal;

    @ApiModelProperty("仓库负责人电话")
    @TableField("warehouse_phone")
    private String warehousePhone;


}
