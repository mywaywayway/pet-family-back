package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.pet.pro.Result;
import com.pet.pro.entity.views.CommentsOrderFormEntity;

import com.pet.pro.mapper.CommentsOrderFormMapper;
import com.pet.pro.mapper.CommodityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 商店信息 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:08:12
 */
@RestController
@RequestMapping("/comments-order-form-entity")
public class CommentsOrderFormController {
   @Autowired
    private CommentsOrderFormMapper commentsOrderFormMapper;
   @Autowired
   private CommodityMapper commodityMapper;
   @GetMapping("/getCommentsOrder/{commodityId}")
    public Result<?> getCommentsOrder(@PathVariable Integer commodityId){
       LambdaQueryWrapper<CommentsOrderFormEntity> queryWrapper = new LambdaQueryWrapper<>();
       queryWrapper.eq(CommentsOrderFormEntity::getCommodityId, commodityId);
       List<CommentsOrderFormEntity> commentsEntities = commentsOrderFormMapper.selectList(queryWrapper);
       if(commentsEntities.size() > 0) {
           return Result.success(commentsEntities);
       }
       else {
           return Result.fail();
       }
   }

   @GetMapping("/getCommentsByShopId/{shopId}")
    public Result<?> getCommentsByShopId(@PathVariable Integer shopId) {
       List<CommentsOrderFormEntity> result = new ArrayList<>();
       List<CommentsOrderFormEntity> commentsEntities = commentsOrderFormMapper.selectList(null);
       for (int i = 0; i < commentsEntities.size(); i++) {
           int commodityId = commentsEntities.get(i).getCommodityId();
           if (commodityMapper.selectById(commodityId).getShopId() == shopId) {
               result.add(commentsEntities.get(i));
           }
       }
       if (result.size() > 0) {
           return Result.success(result);
       } else {
           return Result.success(200, "该商店暂无评论");
       }
   }
}

