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
    private Integer id;
    private String name;
    private String photo;
    private String introduce;
    private Double price;
    private Integer shopId;
    private Integer regularUserId;
    private String shoppingCartId;
    private Integer commodityNumber;
    private String avatar;
    private String shopName;
}
