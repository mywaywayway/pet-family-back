package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.entity.views.RegularUserView;
import com.pet.pro.mapper.RegularUserMapper;
import com.pet.pro.mapper.RegularUserViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("RegularUserController")
@RequestMapping("/regular-user-entity")
public class RegularUserController {

    RegularUserMapper regularUserMapper;
    @Autowired
    public void setRegularUserMapper(RegularUserMapper regularUserMapper){
        this.regularUserMapper = regularUserMapper;
    }

    RegularUserViewMapper regularUserViewMapper;
    @Autowired
    public void setRegularUserViewMapper(RegularUserViewMapper regularUserViewMapper){
        this.regularUserViewMapper = regularUserViewMapper;
    }

    @GetMapping("/getRegularUserById/{loginId}")
    public RegularUserEntity getRegularUserById(@PathVariable int loginId){
        return regularUserMapper.selectOne(new QueryWrapper<RegularUserEntity>().eq("login_id",loginId));
    }

    //查询所有用户
    @GetMapping("/getAllRegularUser")
    public Result<List<RegularUserView>> getAllRegularUser(){
        List<RegularUserView> list = regularUserViewMapper.selectList(null);
        return Result.success(list);
    }


}

