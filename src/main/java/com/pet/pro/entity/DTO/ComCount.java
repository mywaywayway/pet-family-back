package com.pet.pro.entity.DTO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

/**
 * @description : 用于统计商品的种类名称及其数量
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/12
 */
@Data
@ToString
@TableName(value = "com_type_count_view")
public class ComCount {
    @TableField(value = "shop_id")
    Integer shopId;  // 商店id
    @TableField(value = "com_type_name")
    String comTypeName;  // 商品种类名称
    @TableField(value = "com_type_count")
    Integer comTypeCount;  // 商品种类数量
}
