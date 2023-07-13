package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.mapper.OrderFormMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController("OrderFormController")
@RequestMapping("/order-form-entity")
public class OrderFormController {

    private OrderFormMapper orderFormMapper;
    @Autowired
    public void setOrderFormMapper(OrderFormMapper orderFormMapper) {
        this.orderFormMapper = orderFormMapper;
    }


    @ApiOperation("用户下单")
    @PostMapping("/submitOrder")
    public Result<?> getOrder(@RequestBody OrderFormEntity order){
        if(orderFormMapper.insert(order)==1){

            return Result.success();
        }
        else{
            return Result.fail();
        }
    }


}

