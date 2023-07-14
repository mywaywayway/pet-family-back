package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.DTO.OrderAddrDTO;
import com.pet.pro.entity.DTO.OrderInfoDTO;
import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.entity.OrderGoodsEntity;
import com.pet.pro.entity.StorageEntity;
import com.pet.pro.entity.Vo.OrderInfoVo;
import com.pet.pro.mapper.OrderFormMapper;
import com.pet.pro.service.CommodityService;
import com.pet.pro.service.OrderFormService;
import com.pet.pro.service.OrderGoodsService;
import com.pet.pro.service.StorageService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    @Autowired
    private OrderGoodsService orderGoodsService;

    @Autowired
    private StorageService storageService;

    @Autowired
    private CommodityService commodityService;

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


    /**
     * 通过订单id修改收货人信息
     * @param id  订单id
     * @return
     */
    @ApiModelProperty("修改订单")
    @PostMapping("updateOrder/{id}")
    public Result<?> updateOrder(@RequestBody OrderAddrDTO orderAddrDTO,@PathVariable String id){
        Result<OrderAddrDTO> result = new Result<>();
        OrderFormEntity orderFormEntity = orderFormService.getById(id);
        orderFormEntity.setAddress(orderAddrDTO.getAddress());
        orderFormEntity.setPhone(orderAddrDTO.getPhone());
        orderFormEntity.setName(orderAddrDTO.getName());
        if (orderFormService.updateById(orderFormEntity)){
            result.setCode(200);
            result.setMessage("修改成功");
        }else {
            result.setMessage("修改失败");
            result.setCode(500);
        }

        return result;
    }

    /**
     * 根据商家id查询订单
     * @param id 商家id
     * @return
     */
    @ApiModelProperty("查询订单")
    @GetMapping("listOrder/{id}")
    public Result<?> listOrder(@PathVariable String id){
        QueryWrapper<CommodityEntity> wrapper = new QueryWrapper<>();
        List<OrderInfoDTO> list = new ArrayList<>();
        wrapper.eq("shop_id",id);
        List<CommodityEntity> commodityEntityList = commodityService.list(wrapper);
        int[] sid = new int[commodityEntityList.size()];
        for (int i = 0; i < commodityEntityList.size(); i++) {
            sid[i] = commodityEntityList.get(i).getId();
        }
        int t = 0;
        int[] ssid = getDistinctNumbers(sid);
        for (int i = 0; i < ssid.length; i++) {
            QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("commodity_id",ssid[i]);
            List<OrderGoodsEntity> list1 = orderGoodsService.list(wrapper1);
            t += list1.size();
        }
        int[] oid = new int[t];
        int kk = 0;
        for (int i = 0; i < ssid.length; i++) {
            QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("commodity_id",ssid[i]);
            List<OrderGoodsEntity> list1 = orderGoodsService.list(wrapper1);
            if (list1.size() == 0) {
                continue;
            }
            for (int j = 0; j < list1.size(); j++,kk++) {
                oid[kk] = list1.get(j).getOrderId();
            }
        }
        int[] ooid = getDistinctNumbers(oid);
        //找到本商家的订单号
        for (int i = 0; i < ooid.length; i++) {
            QueryWrapper<OrderFormEntity> orderFormEntityQueryWrapper = new QueryWrapper<>();
            orderFormEntityQueryWrapper.eq("id",getDistinctNumbers(ooid)[i]);
            OrderFormEntity orderFormEntity = orderFormService.getOne(orderFormEntityQueryWrapper);
            if (orderFormEntity.getState().equals("未付款")) {
                continue;
            }
            OrderInfoDTO orderInfoDTO = new OrderInfoDTO();
            orderInfoDTO.setOrderFormEntity(orderFormEntity);
            QueryWrapper<OrderGoodsEntity> orderGoodsEntityQueryWrapper1 = new QueryWrapper<>();
            orderGoodsEntityQueryWrapper1.eq("order_id",getDistinctNumbers(ooid)[i]);
            List<OrderGoodsEntity> orderGoodsEntityList2 = orderGoodsService.list(orderGoodsEntityQueryWrapper1);
            List<OrderInfoVo> orderInfoVoList = new ArrayList<>();
            for (int j = 0; j < sid.length; j++) {
                for (int k = 0; k < orderGoodsEntityList2.size(); k++) {
                    if (orderGoodsEntityList2.get(k).getCommodityId() == sid[j]){
                        OrderInfoVo orderInfoVo = new OrderInfoVo();
                        orderInfoVo.setOrderGoodsEntity(orderGoodsEntityList2.get(k));
                        QueryWrapper<CommodityEntity> wrapper1 = new QueryWrapper<>();
                        wrapper1.eq("id",orderGoodsEntityList2.get(k).getCommodityId());
                        orderInfoVo.setName(commodityService.getOne(wrapper1).getName());
                        orderInfoVoList.add(orderInfoVo);
                    }
                }
            }
            orderInfoDTO.setList(orderInfoVoList);
            list.add(orderInfoDTO);
        }
        return Result.success(list);
    }


    /**
     * 去除数组重复数据
     * @param array
     * @return
     */
    public int[] getDistinctNumbers(int[] array){
        Set<Integer> distinctSet = new HashSet<>();

        // 将数组中的元素添加到Set中
        for (int i = 0; i < array.length; i++) {
            distinctSet.add(array[i]);
        }

        // 创建一个新的整数数组来存储不重复的数
        int[] distinctNumbers = new int[distinctSet.size()];

        // 将不重复的数从Set中拷贝到新的数组中
        int index = 0;
        for (int num : distinctSet) {
            distinctNumbers[index++] = num;
        }

        // 返回不重复的数的数组
        return distinctNumbers;
    }



    @ApiOperation("商家同意退货")
    @GetMapping("passRet/{id}")
    public Result<?> passRet(@PathVariable Integer id){
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("已退款");
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id",id);
        List<OrderGoodsEntity> list = orderGoodsService.list(wrapper1);
        for (int i = 0; i < list.size(); i++) {
            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
            commodityEntityQueryWrapper.eq("id",list.get(i).getCommodityId());
            CommodityEntity commodity = commodityService.getOne(commodityEntityQueryWrapper);
            commodity.setSaleVolume(commodity.getSaleVolume()-list.get(i).getNum());
            commodityService.updateById(commodity);
            QueryWrapper<StorageEntity> storageEntityQueryWrapper = new QueryWrapper<>();
            storageEntityQueryWrapper.eq("commodity_id",list.get(i).getCommodityId());
            StorageEntity storage = storageService.getOne(storageEntityQueryWrapper);
            storage.setQuantity(storage.getQuantity()+list.get(i).getNum());
            storageService.updateById(storage);
        }
        orderFormService.updateById(orderFormEntity);
        return Result.success();
    }

    @ApiOperation("商家同意发货")
    @GetMapping("passDeliver/{id}")
    public Result<?> passDeliver(@PathVariable Integer id){
        QueryWrapper<OrderFormEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        OrderFormEntity orderFormEntity = orderFormService.getOne(wrapper);
        orderFormEntity.setState("已发货");
        QueryWrapper<OrderGoodsEntity> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("order_id",id);
        List<OrderGoodsEntity> list = orderGoodsService.list(wrapper1);
        for (int i = 0; i < list.size(); i++) {
            QueryWrapper<CommodityEntity> commodityEntityQueryWrapper = new QueryWrapper<>();
            commodityEntityQueryWrapper.eq("id",list.get(i).getCommodityId());
//            CommodityEntity commodity = commodityService.getOne(commodityEntityQueryWrapper);
//            commodity.setSaleVolume(commodity.getSaleVolume()+list.get(i).getNum());
//            commodityService.updateById(commodity);
            QueryWrapper<StorageEntity> storageEntityQueryWrapper = new QueryWrapper<>();
            storageEntityQueryWrapper.eq("commodity_id",list.get(i).getCommodityId());
//            StorageEntity storage = storageService.getOne(storageEntityQueryWrapper);
//            storage.setQuantity(storage.getQuantity()-list.get(i).getNum());
//            storageService.updateById(storage);
        }
        orderFormService.updateById(orderFormEntity);
        return Result.success();
    }
}

