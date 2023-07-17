package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommentsEntity;
import com.pet.pro.entity.views.CommentsOrderFormEntity;
import com.pet.pro.mapper.CommentsMapper;
import com.pet.pro.mapper.CommentsOrderFormMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

