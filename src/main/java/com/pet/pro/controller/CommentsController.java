package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommentsEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.mapper.CommentsMapper;
import com.pet.pro.mapper.ShopMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/comments-entity")
public class CommentsController {
    @Autowired
    private CommentsMapper commentsMapper;

    @GetMapping("/getComments/{commotityId}")
    public Result<?> getCommentsByCommotityId(@PathVariable Integer commotityId) {
        LambdaQueryWrapper<CommentsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommentsEntity::getCommodityId, commotityId);
        List<CommentsEntity> commentsEntities = commentsMapper.selectList(queryWrapper);
        if(commentsEntities.size() > 0) {
            return Result.success(commentsEntities);
        }
        else {
            return Result.fail();
        }
    }

    @PostMapping("/addComments")
    public Result<?> addComments(@RequestBody CommentsEntity commentsEntity){
        if(commentsMapper.insert(commentsEntity)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }
}

