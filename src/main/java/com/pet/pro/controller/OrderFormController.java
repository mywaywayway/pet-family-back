package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.*;
import com.pet.pro.entity.DTO.OrderAddrDTO;
import com.pet.pro.entity.DTO.OrderInfoDTO;
import com.pet.pro.entity.DTO.ShopCarDTO;
import com.pet.pro.entity.Vo.OrderInfoVo;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.OrderFormMapper;
import com.pet.pro.service.ComGoodsService;
import com.pet.pro.service.CommodityService;
import com.pet.pro.service.OrderFormService;
import com.pet.pro.service.StorageService;
import com.pet.pro.service.impl.OrderGoodsServiceImpl;
import com.pet.pro.service.impl.ShopServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


@RestController("OrderFormController")
@RequestMapping("/order-form-entity")
public class OrderFormController {

    private OrderFormMapper orderFormMapper;

    @Autowired
    public void setOrderFormMapper(OrderFormMapper orderFormMapper) {
        this.orderFormMapper = orderFormMapper;
    }

    @Autowired
    private OrderFormService orderFormService;


    private OrderGoodsServiceImpl orderGoodsService;

    @Autowired
    public void setOrderGoodsService(OrderGoodsServiceImpl orderGoodsService) {
        this.orderGoodsService = orderGoodsService;
    }

    @Autowired
    private StorageService storageService;

    @Autowired
    private CommodityService commodityService;

    @Autowired
    private ComGoodsService comGoodsService;

    private ShopServiceImpl shopService;

    @Autowired
    public void setShopService(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @ApiOperation("用户下单")
    @PostMapping("/submitOrder")
    public Result<?> getOrder(@RequestBody OrderFormEntity order) {
        System.out.println(order.getTime());
        if (orderFormMapper.insert(order) == 1) {
            Integer id = order.getId();
            return Result.success(id);
        } else {
            return Result.fail();
        }
    }


    /**
     * 通过订单id修改收货人信息
     *
     * @param id 订单id
     * @return
     */
    @ApiModelProperty("修改订单")
    @PostMapping("updateOrder/{id}")
    public Result<?> updateOrder(@RequestBody OrderAddrDTO orderAddrDTO, @PathVariable String id) {
        Result<OrderAddrDTO> result = new Result<>();
        OrderFormEntity orderFormEntity = orderFormService.getById(id);
        orderFormEntity.setAddress(orderAddrDTO.getAddress());
        orderFormEntity.setPhone(orderAddrDTO.getPhone());
        orderFormEntity.setName(orderAddrDTO.getName());
        if (orderFormService.updateById(orderFormEntity)) {
            result.setCode(200);
            result.setMessage("修改成功");
        } else {
            result.setMessage("修改失败");
            result.setCode(500);
        }

        return result;
    }

//    /**
//     * 根据商家id查询订单
//     * @param id 商家id
//     * @return 订单列表
//     */
////    @ApiModelProperty("查询订单")
////    @GetMapping("listOrder/{id}")
////    public Result<?> listOrder(@PathVariable String id){
////        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
////        List<OrderInfoDTO> list = new ArrayList<>();
////        wrapper.eq("shop_id",id);
////        List<CommodityEntity> commodityEntityList = commodityService.list(wrapper);
////        int[] sid = new int[commodityEntityList.size()];
////        for (int i = 0; i < commodityEntityList.size(); i++) {
////            sid[i] = commodityEntityList.get(i).getId();
////        }
////        int t = 0;
////        int[] ssid = getDistinctNumbers(sid);
////        for (int i = 0; i < ssid.length; i++) {
////            QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
////            wrapper1.eq("commodity_id",ssid[i]);
////            List<OrderGoodsEntity> list1 = orderGoodsService.list(wrapper1);
////            t += list1.size();
////        }
////        int[] oid = new int[t];
////        int kk = 0;
////        for (int i = 0; i < ssid.length; i++) {
////            QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
////            wrapper1.eq("commodity_id",ssid[i]);
////            List<OrderGoodsEntity> list1 = orderGoodsService.list(wrapper1);
////            if (list1.size() == 0) {
////                continue;
////            }
////            for (int j = 0; j < list1.size(); j++,kk++) {
////                oid[kk] = list1.get(j).getOrderId();
////            }
////        }
////        int[] ooid = getDistinctNumbers(oid);
////        //找到本商家的订单号
////        for (int i = 0; i < ooid.length; i++) {
////            QueryWrapper<OrderFormEntity> orderFormEntityQueryWrapper = new QueryWrapper<>();
////            orderFormEntityQueryWrapper.eq("id",getDistinctNumbers(ooid)[i]);
////            OrderFormEntity orderFormEntity = orderFormService.getOne(orderFormEntityQueryWrapper);
////            if (orderFormEntity.getState().equals("未付款")) {
////                continue;
////            }
////            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
////            orderInfoDTO.setOrderFormEntity(orderFormEntity);
////            QueryWrapper<OrderGoodsEntity> orderGoodsEntityQueryWrapper1 = new QueryWrapper<>();
////            orderGoodsEntityQueryWrapper1.eq("order_id",getDistinctNumbers(ooid)[i]);
////            List<OrderGoodsEntity> orderGoodsEntityList2 = orderGoodsService.list(orderGoodsEntityQueryWrapper1);
////            List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
////            for (int j = 0; j < sid.length; j++) {
////                for (int k = 0; k < orderGoodsEntityList2.size(); k++) {
////                    if (orderGoodsEntityList2.get(k).getCommodityId() == sid[j]){
////                        OrderInfoVo orderInfoVo = new OrderInfoVo();
////                        orderInfoVo.setOrderGoodsEntity(orderGoodsEntityList2.get(k));
////                        QueryWrapper<CommodityEntity> wrapper1 = new QueryWrapper<>();
////                        wrapper1.eq("id",orderGoodsEntityList2.get(k).getCommodityId());
////                        orderInfoVo.setName(commodityService.getOne(wrapper1).getName());
////                        orderInfoVo.setPhoto(commodityService.getOne(wrapper1).getPhoto());
////                        orderInfoVoList.add(orderInfoVo);
////                    }
////                }
////            }
////            orderInfoDTO.setList(orderInfoVoList);
////            list.add(orderInfoDTO);
////        }
////        return Result.success(list);
////    }

    /**
     * 根据商家id查询订单
     *
     * @param id 商家id
     * @return 订单列表
     */
    @ApiOperation("查询订单")
    @GetMapping("/listOrder/{id}")
    public Result<?> test(@PathVariable Integer id) {
        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("shop_id", id);
        List<CommodityEntity> commodityEntityList = commodityService.list(wrapper);
        HashSet<Integer> cid = new HashSet<>();
        Integer t = 0;
        for (CommodityEntity commodityEntity : commodityEntityList) {
            cid.add(commodityEntity.getId());
            t++;
        }
        System.out.println(t);
        HashSet<Integer> oid = new HashSet<>();
        List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list();
        for (OrderGoodsEntity orderGoodsEntity : orderGoodsEntityList) {
            if (cid.contains(orderGoodsEntity.getCommodityId())) {
                oid.add(orderGoodsEntity.getOrderId());
            }
            t++;
        }
        System.out.println(t);
        List<OrderInfoDTO> list = new ArrayList<>();
        for (Integer integer : oid) {
            QueryWrapper<OrderFormEntity> orderFormEntityQueryWrapper = new QueryWrapper<>();
            orderFormEntityQueryWrapper.eq("id", integer);
            OrderFormEntity orderFormEntity = orderFormService.getOne(orderFormEntityQueryWrapper);
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderFormEntity(orderFormEntity);
            QueryWrapper<OrderGoodsEntity> orderGoodsEntityQueryWrapper1 = new QueryWrapper<>();
            orderGoodsEntityQueryWrapper1.eq("order_id", integer);
            List<OrderGoodsEntity> orderGoodsEntityList2 = orderGoodsService.list(orderGoodsEntityQueryWrapper1);
            List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
            for (OrderGoodsEntity orderGoodsEntity : orderGoodsEntityList2) {
                OrderInfoVo orderInfoVo = new OrderInfoVo();
                orderInfoVo.setOrderGoodsEntity(orderGoodsEntity);
                QueryWrapper<CommodityEntity> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("id", orderGoodsEntity.getCommodityId());
                orderInfoVo.setName(commodityService.getOne(wrapper1).getName());
                orderInfoVo.setPhoto(commodityService.getOne(wrapper1).getPhoto());
                orderInfoVoList.add(orderInfoVo);
                t++;
            }
            orderInfoDTO.setList(orderInfoVoList);
            list.add(orderInfoDTO);
        }
        System.out.println(t);

        return Result.success(list);
    }




    /**
     * 商家同意退货
     *
     * @param id 订单id
     * @return 是否成功
     */

    @ApiOperation("商家同意退货")
    @GetMapping("passRet/{id}")
    public Result<?> passRet(@PathVariable Integer id) {
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("已退款");
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id", id);
        List<OrderGoodsEntity> list = orderGoodsService.list(wrapper1);
        for (int i = 0; i < list.size(); i++) {
            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
            commodityEntityQueryWrapper.eq("id", list.get(i).getCommodityId());
            CommodityEntity commodity = commodityService.getOne(commodityEntityQueryWrapper);
            commodity.setSaleVolume(commodity.getSaleVolume() - list.get(i).getNum());
            commodityService.updateById(commodity);
            QueryWrapper<StorageEntity> storageEntityQueryWrapper = new QueryWrapper<>();
            storageEntityQueryWrapper.eq("commodity_id", list.get(i).getCommodityId());
            StorageEntity storage = storageService.getOne(storageEntityQueryWrapper);
            storage.setQuantity(storage.getQuantity() + list.get(i).getNum());
            storageService.updateById(storage);
        }
        orderFormService.updateById(orderFormEntity);
        return Result.success();
    }

    /**
     * 商家同意发货
     *
     * @param id 订单id
     * @return 是否成功
     */
    @ApiOperation("商家同意发货")
    @GetMapping("passDeliver/{id}")
    public Result<?> passDeliver(@PathVariable Integer id) {
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("已发货");
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id", id);
        List<OrderGoodsEntity> list = orderGoodsService.list(wrapper1);
        for (int i = 0; i < list.size(); i++) {
            OrderGoodsEntity orderGoodsEntity = list.get(i);
            orderFormEntity.setState("已发货");
            orderGoodsService.updateById(orderGoodsEntity);
            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
            commodityEntityQueryWrapper.eq("id", list.get(i).getCommodityId());
            CommodityEntity commodity = commodityService.getOne(commodityEntityQueryWrapper);
            commodity.setSaleVolume(commodity.getSaleVolume() + list.get(i).getNum());
            commodityService.updateById(commodity);
        }
        orderFormService.updateById(orderFormEntity);
        return Result.success();
    }

    /**
     * 购物车下单
     *
     * @param shopCarDTO 订单信息
     * @return 订单信息
     */
    @ApiOperation("购物车下单")
    @PostMapping("saveOrder")
    public Result<?> saveOrder(@RequestBody ShopCarDTO shopCarDTO) {
        List<OrderFormEntity> orderFormEntityList = new ArrayList<>();
        HashSet<Integer> sid = new HashSet<>();
        for (int i = 0; i < shopCarDTO.getList().size(); i++) {
            QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("id", shopCarDTO.getList().get(i).getCommodityId());
            System.out.println(shopCarDTO.getList().get(i).getCommodityId());
            CommodityEntity commodityEntity = commodityService.getOne(wrapper);
            sid.add(commodityEntity.getShopId());
        }
        for (Integer integer : sid) {
            QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("shop_id", integer);
            List<CommodityEntity> commodityEntityList = commodityService.list(wrapper);
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < commodityEntityList.size(); j++) {
                list.add(commodityEntityList.get(j).getId());
            }
            List<OrderGoodsEntity> list1 = new ArrayList<>();
            for (int j = 0; j < shopCarDTO.getList().size(); j++) {
                if (list.contains(shopCarDTO.getList().get(j).getCommodityId())) {
                    list1.add(shopCarDTO.getList().get(j));
                }
            }
            Double totalPrice = 0.0;
            OrderFormEntity newOrderFormEntity = new OrderFormEntity();
            BeanUtils.copyProperties(shopCarDTO.getOrderFormEntity(), newOrderFormEntity);
            orderFormService.save(newOrderFormEntity);
            Integer id = newOrderFormEntity.getId();
            for (int j = 0; j < list1.size(); j++) {
                OrderGoodsEntity orderGoodsEntity = list1.get(j);
                orderGoodsEntity.setOrderId(id);
                CommodityEntity commodityEntity = commodityService.getOne(new QueryWrapper<CommodityEntity>().eq("id", shopCarDTO.getList().get(j).getCommodityId()));
                orderGoodsEntity.setTotalPrice(commodityEntity.getPrice() * orderGoodsEntity.getNum());
                orderGoodsEntity.setState("待付款");
                totalPrice += orderGoodsEntity.getTotalPrice();
                orderGoodsService.save(orderGoodsEntity);
                StorageEntity storageEntity = storageService.getOne(new QueryWrapper<StorageEntity>().eq("commodity_id", orderGoodsEntity.getCommodityId()));
                storageEntity.setQuantity(storageEntity.getQuantity() - orderGoodsEntity.getNum());
                storageService.updateById(storageEntity);
            }
            newOrderFormEntity.setTotalPrice(totalPrice);
            newOrderFormEntity.setState("待付款");
            orderFormService.updateById(newOrderFormEntity);
            orderFormEntityList.add(newOrderFormEntity);
        }
        return Result.success(orderFormEntityList);
    }

    /**
     * 付款
     *
     * @param list 订单信息
     * @return 是否成功
     */
    @ApiOperation("付款")
    @PostMapping("payOrder")
    public Result<?> payOrder(@RequestBody List<OrderFormEntity> list) {
        for (int i = 0; i < list.size(); i++) {
            OrderFormEntity orderFormEntity = list.get(i);
            orderFormEntity.setState("已付款");
            orderFormService.updateById(orderFormEntity);
            QueryWrapper<OrderGoodsEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("order_id", orderFormEntity.getId());
            List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list(wrapper);
            for (int j = 0; j < orderGoodsEntityList.size(); j++) {
                OrderGoodsEntity orderGoodsEntity = orderGoodsEntityList.get(j);
                orderGoodsEntity.setState("已付款");
                orderGoodsService.updateById(orderGoodsEntity);
            }
        }
        return Result.success();
    }

    /**
     * 删除订单
     *
     * @param orderId 订单id
     * @return 是否成功
     */
    //删除订单
    @GetMapping("/deleteOrder/{orderId}")
    public Result<?> deleteOrder(@PathVariable Integer orderId) {
        if (orderFormMapper.deleteById(orderId) == 1) {
            return Result.success();
        } else {
            return Result.fail();
        }

    }


    /**
     * 定时删除未付款订单
     *
     * @param id 用户id
     * @return
     */
    @ApiOperation("删除半小时未付款的订单")
    @GetMapping("deleteHalfUnpaidOrder/{id}")
    public Result<?> deleteHalfUnpaidOrder(@PathVariable Integer id) {
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("person_id", id);
        wrapper.eq("state", "待付款");
        List<OrderFormEntity> list = orderFormService.list(wrapper);
        if (list == null) {
            return Result.success();
        }
        for (int i = 0; i < list.size(); i++) {
            LocalDateTime end = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime start = LocalDateTime.parse(list.get(i).getTime(), formatter);
            long diff = Duration.between(start, end).toMinutes();
            if (diff > 30) {
                QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("order_id", list.get(i).getId());
                List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list(wrapper1);
                for (int j = 0; j < orderGoodsEntityList.size(); j++) {
                    QueryWrapper<StorageEntity> wrapper2 = new QueryWrapper<>();
                    wrapper2.eq("commodity_id", orderGoodsEntityList.get(j).getCommodityId());
                    StorageEntity storageEntity = storageService.getOne(wrapper2);
                    storageEntity.setQuantity(storageEntity.getQuantity() + orderGoodsEntityList.get(j).getNum());
                    storageService.updateById(storageEntity);
                }
                orderGoodsService.remove(wrapper1);
                orderFormService.removeById(list.get(i).getId());
            }
        }
        return Result.success();
    }


    /**
     * 根据用户id查询全部订单
     *
     * @param id 用户id
     * @return 订单信息
     */
    @ApiOperation("客户查看个人订单")
    @GetMapping("viewOrder/{id}")
    public Result<?> viewOrder(@PathVariable Integer id) {
        List<OrderInfoDTO> list = new ArrayList<>();
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("person_id", id);

        List<OrderFormEntity> orderFormEntityList = orderFormService.list(wrapper);

        for (OrderFormEntity orderFormEntity : orderFormEntityList) {
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderFormEntity(orderFormEntity);

            // 执行关联查询，获取订单商品列表
            QueryWrapper<OrderGoodsEntity> orderGoodsWrapper = new QueryWrapper<>();
            orderGoodsWrapper.eq("order_id", orderFormEntity.getId());
            List<OrderGoodsEntity> orderGoodsList = orderGoodsService.list(orderGoodsWrapper);
            orderFormEntity.setOrderGoodsList(orderGoodsList);
            List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
            for (int i = 0; i < orderGoodsList.size(); i++) {
                QueryWrapper<ComGoodsView> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("id",orderGoodsList.get(i).getCommodityId());
                OrderInfoVo orderInfoVo = new OrderInfoVo();
                orderInfoVo.setOrderGoodsEntity(orderGoodsList.get(i));
                ComGoodsView comGoodsView = comGoodsService.getOne(wrapper1);
                orderInfoVo.setName(comGoodsView.getCommodityName());
                orderInfoVo.setPhoto(comGoodsView.getPhoto());
                orderInfoVo.setShopName(comGoodsView.getShopName());
                orderInfoVoList.add(orderInfoVo);
            }
            orderInfoDTO.setList(orderInfoVoList);

            list.add(orderInfoDTO);
        }

        return Result.success(list);
    }

    /**
     * 根据商家id查询已完成订单
     *
     * @param id 商家id
     * @return 订单信息
     */
    @ApiModelProperty("查询已完成订单")
    @GetMapping("getFinish/{id}")
    public Result<?> getFinish(@PathVariable String id) {
        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("shop_id", id);
        List<CommodityEntity> commodityEntityList = commodityService.list(wrapper);
        HashSet<Integer> cid = new HashSet<>();
        for (CommodityEntity commodityEntity : commodityEntityList) {
            cid.add(commodityEntity.getId());
        }
        HashSet<Integer> oid = new HashSet<>();
        List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list();
        for (OrderGoodsEntity orderGoodsEntity : orderGoodsEntityList) {
            if (cid.contains(orderGoodsEntity.getCommodityId())) {
                oid.add(orderGoodsEntity.getOrderId());
            }
        }
        List<OrderInfoDTO> list = new ArrayList<>();
        for (Integer integer : oid) {
            QueryWrapper<OrderFormEntity> orderFormEntityQueryWrapper = new QueryWrapper<>();
            orderFormEntityQueryWrapper.eq("id", integer);
            OrderFormEntity orderFormEntity = orderFormService.getOne(orderFormEntityQueryWrapper);
            if (!orderFormEntity.getState().equals("已完成") && orderFormEntity.getState().equals("已收货")) {
                continue;
            }
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderFormEntity(orderFormEntity);
            QueryWrapper<OrderGoodsEntity> orderGoodsEntityQueryWrapper1 = new QueryWrapper<>();
            orderGoodsEntityQueryWrapper1.eq("order_id", integer);
            List<OrderGoodsEntity> orderGoodsEntityList2 = orderGoodsService.list(orderGoodsEntityQueryWrapper1);
            List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
            for (OrderGoodsEntity orderGoodsEntity : orderGoodsEntityList2) {
                OrderInfoVo orderInfoVo = new OrderInfoVo();
                orderInfoVo.setOrderGoodsEntity(orderGoodsEntity);
                QueryWrapper<CommodityEntity> wrapper1 = new QueryWrapper<>();
                wrapper1.eq("id", orderGoodsEntity.getCommodityId());
                orderInfoVo.setName(commodityService.getOne(wrapper1).getName());
                orderInfoVo.setPhoto(commodityService.getOne(wrapper1).getPhoto());
                orderInfoVoList.add(orderInfoVo);
            }
            orderInfoDTO.setList(orderInfoVoList);
            list.add(orderInfoDTO);
        }
        return Result.success(list);
    }


    /**
     * 用户同意收货
     *
     * @param id 订单id
     * @return 是否成功
     */
    @ApiOperation("用户同意收货")
    @GetMapping("pass/{id}")
    public Result<?> agreeOrder(@PathVariable Integer id) {
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("已收货");
        orderFormService.updateById(orderFormEntity);
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id", orderFormEntity.getId());
        List<OrderGoodsEntity> orderGoodsEntityList = orderGoodsService.list(wrapper1);
        for (int i = 0; i < orderGoodsEntityList.size(); i++) {
            OrderGoodsEntity orderGoodsEntity = orderGoodsEntityList.get(i);
            orderGoodsEntity.setState("待评价");
            orderGoodsService.updateById(orderGoodsEntity);
        }
        return Result.success();
    }

    /**
     * 用户申请退款
     *
     * @param id 订单id
     * @return 是否成功
     */
    @ApiOperation("用户申请退款")
    @GetMapping("requestRefund/{id}")
    public Result<?> requestRefund(@PathVariable Integer id) {
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("申请退款");
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id", id);
        List<OrderGoodsEntity> list = orderGoodsService.list(wrapper1);
        for (int i = 0; i < list.size(); i++) {
            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
            commodityEntityQueryWrapper.eq("id", list.get(i).getCommodityId());
            QueryWrapper<StorageEntity> storageEntityQueryWrapper = new QueryWrapper<>();
            storageEntityQueryWrapper.eq("commodity_id", list.get(i).getCommodityId());
        }
        orderFormService.updateById(orderFormEntity);
        return Result.success();
    }

    /**
     * 用户付款
     *
     * @param orderId 订单id
     * @return 是否成功
     */
    @ApiOperation("付款")
    @GetMapping("/payment/{orderId}")
    public Result<?> payment(@PathVariable Integer orderId) {
        LambdaQueryWrapper<OrderFormEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OrderFormEntity::getId, orderId);
        OrderFormEntity orderFormEntity = orderFormMapper.selectOne(queryWrapper);
        orderFormEntity.setState("已付款");
        orderFormMapper.updateById(orderFormEntity);
        return Result.success();
    }


}

