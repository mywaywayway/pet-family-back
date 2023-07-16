package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.DTO.OrderInfoDTO;
import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.entity.OrderGoodsEntity;
import com.pet.pro.entity.Vo.OrderInfoVo;
import com.pet.pro.entity.views.OrderTotalInfoViewEntity;
import com.pet.pro.mapper.OrderGoodsMapper;
import com.pet.pro.mapper.OrderTotalInfoMapper;
import com.pet.pro.service.CommodityService;
import com.pet.pro.service.OrderFormService;
import com.pet.pro.service.OrderGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:08:12
 */
@RestController
@RequestMapping("/order-total-info-entity")
public class OrderTotalInfoViewController {
    @Autowired
    private OrderTotalInfoMapper orderTotalInfoMapper;

//    @Autowired
//    private OrderGoodsService orderGoodsService;
//
//    @Autowired
//    private CommodityService commodityService;
//
//    @Autowired
//    private OrderFormService orderFormService;

    //获取个人所有未支付订单
    @PostMapping("/getUnpayOrder/{userId}")
    public Result<?> getOrder(@PathVariable Integer userId) {
        LambdaQueryWrapper<OrderTotalInfoViewEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderTotalInfoViewEntity::getPersonId, userId)
                .eq(OrderTotalInfoViewEntity::getState,"未付款");
        List<OrderTotalInfoViewEntity> orderTotalInfoViewEntities = orderTotalInfoMapper.selectList(queryWrapper);
        if(orderTotalInfoViewEntities==null){
            return Result.fail();
        }else{
            return Result.success(orderTotalInfoViewEntities);
        }
    }
    //获取个人所有已支付订单
    @PostMapping("/getPaidOrder/{userId}")
    public Result<?> getPaidOrder(@PathVariable Integer personId){
        LambdaQueryWrapper<OrderTotalInfoViewEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderTotalInfoViewEntity::getState,"已付款")
                .eq(OrderTotalInfoViewEntity::getPersonId, personId);
        List<OrderTotalInfoViewEntity> orderTotalInfoViewEntities = orderTotalInfoMapper.selectList(queryWrapper);
        if(orderTotalInfoViewEntities.size()==0){
            return Result.fail();
        }
        else{
            return Result.success(orderTotalInfoViewEntities);
        }
    }


//    @GetMapping("/orderInfo/{id}")
//    public Result<?> getOrderIngoVo(@PathVariable Integer orderId){
////        LambdaQueryWrapper<OrderFormEntity> queryWrapper = new LambdaQueryWrapper<>();
////        queryWrapper.eq()
//        OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
//        QueryWrapper<OrderFormEntity> orderFormEntityQueryWrapper = new QueryWrapper<>();
//        orderFormEntityQueryWrapper.eq("id", orderId);
//        orderInfoDTO.setOrderFormEntity(orderFormService.getOne(orderFormEntityQueryWrapper));
//        QueryWrapper<OrderGoodsEntity> orderGoodsEntityQueryWrapper = new QueryWrapper<>();
//        orderGoodsEntityQueryWrapper.eq("order_id",orderId);
//        List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list(orderGoodsEntityQueryWrapper);
//        List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
//        for (int i = 0; i < orderGoodsEntityList.size(); i++) {
//            OrderInfoVo orderInfoVo = new OrderInfoVo();
//            orderInfoVo.setOrderGoodsEntity(orderGoodsEntityList.get(i));
//            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
//            CommodityEntity commodityEntity = commodityService.getOne(commodityEntityQueryWrapper.eq("id",orderGoodsEntityList.get(i).getCommodityId()));
//            orderInfoVo.setName(commodityEntity.getName());
//            orderInfoVoList.add(orderInfoVo);
//        }
//        orderInfoDTO.setList(orderInfoVoList);
//
//        return Result.success(orderInfoDTO);
//
//    }
}

