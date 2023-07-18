package com.pet.pro.entity.Vo;

import com.pet.pro.entity.views.ShoppingCartViewEntity;
import lombok.Data;

import java.util.List;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/16
 */
@Data
public class CartInfoData {
    private String shopName;
    private List<ShoppingCartViewEntity> goodsViewList;
}
