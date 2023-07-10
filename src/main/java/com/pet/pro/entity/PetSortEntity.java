package com.pet.pro.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 宠物类别
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("pet_sort")
@ApiModel(value = "PetSortEntity对象", description = "宠物类别")
public class PetSortEntity {

    @ApiModelProperty("分类编号")
    @TableId(value = "sort_id", type = IdType.AUTO)
    private Integer sortId;


}
