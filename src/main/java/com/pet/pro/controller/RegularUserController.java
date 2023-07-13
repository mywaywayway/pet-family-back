package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.mapper.RegularUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


@RestController("RegularUserController")
@RequestMapping("/regular-user-entity")
public class RegularUserController {

    RegularUserMapper regularUserMapper;
    @Autowired
    public void setRegularUserMapper(RegularUserMapper regularUserMapper){
        this.regularUserMapper = regularUserMapper;
    }

    @GetMapping("/getRegularUserById/{loginId}")
    public RegularUserEntity getRegularUserById(@PathVariable int loginId){
        return regularUserMapper.selectOne(new QueryWrapper<RegularUserEntity>().eq("login_id",loginId));
    }

}

