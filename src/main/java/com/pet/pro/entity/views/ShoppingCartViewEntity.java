package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@TableName(value = "shopping_cart_view")    // 表名
public class ShoppingCartViewEntity {
    private Integer id;   // 主键
    private String name;  // 商品名称
    private String photo;  // 商品图片
    private String introduce;  // 商品介绍
    private Double price;  // 商品价格
    private Integer shopId;  // 店铺id
    private Integer regularUserId;  // 普通用户id
    private Integer shoppingCartId;  // 购物车id
    private Integer commodityNumber;  // 商品数量
    private String avatar;  // 店铺头像
    private String shopName;  // 店铺名称
}
