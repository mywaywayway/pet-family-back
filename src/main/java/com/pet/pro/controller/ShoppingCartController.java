package com.pet.pro.controller;

import com.pet.pro.service.impl.ShoppingCartViewServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/16
 */
@RestController("ShoppingCartController")
@RequestMapping("/shopping-cart-entity")
public class ShoppingCartController {

    private ShoppingCartViewServiceImpl shoppingCartViewService;

    @Autowired
    public void setShoppingCartViewService(ShoppingCartViewServiceImpl shoppingCartViewService) {
        this.shoppingCartViewService = shoppingCartViewService;
    }
}
