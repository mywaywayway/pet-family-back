package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.views.UserTotalInfoViewEntity;
import com.pet.pro.mapper.UserTotalInfoViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("UserTotalInfoViewController")
@RequestMapping("/userTotalInfoViewEntity")
public class UserTotalInfoViewController {
    @Autowired
    private UserTotalInfoViewMapper userTototalInfoViewManager;

    @GetMapping("/getUserInfoById/{userId}")
    public Result<?> getUserInfoById(@PathVariable Integer userId) {
        LambdaQueryWrapper<UserTotalInfoViewEntity> query = new LambdaQueryWrapper<>();
        query.eq(UserTotalInfoViewEntity::getUserId, userId);
        List<UserTotalInfoViewEntity> userTotalInfoViewEntities = userTototalInfoViewManager.selectList(query);
        return Result.success(userTotalInfoViewEntities);
    }
}

