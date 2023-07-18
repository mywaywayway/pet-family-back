package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.OrderGoodsEntity;
import com.pet.pro.mapper.OrderGoodsMapper;
import com.pet.pro.service.OrderGoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("OrderGoodsController")
@RequestMapping("/order-goods-entity")
public class OrderGoodsController {
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    @Autowired
    private OrderGoodsService orderGoodsService;

    @PostMapping("/addOrderGoods")

    public Result<?> addOrderGoods(@RequestBody OrderGoodsEntity entity) {
        if(orderGoodsMapper.insert(entity)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }

    @GetMapping("/deleteOrderGoods/{orderId}")
    public Result<?> deleteOrderGoods(@PathVariable Integer orderId){
        LambdaQueryWrapper<OrderGoodsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderGoodsEntity::getOrderId, orderId);
        OrderGoodsEntity orderGoodsEntity = orderGoodsMapper.selectOne(queryWrapper);
        if(orderGoodsEntity!=null){
            orderGoodsMapper.delete(queryWrapper);
            return Result.success(orderGoodsEntity);
        }
        else{
            return Result.fail();
        }
    }

    @ApiOperation("订单详情状态改为已评价")
    @GetMapping("pass/{id}")
    public Result<?> agreeOrder(@PathVariable Integer id){
        QueryWrapper<OrderGoodsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        OrderGoodsEntity orderGoodsEntity = orderGoodsService.getOne(wrapper);
        orderGoodsEntity.setState("已评价");
        orderGoodsService.updateById(orderGoodsEntity);
        return Result.success();
    }
}

