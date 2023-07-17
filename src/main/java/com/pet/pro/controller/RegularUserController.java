package com.pet.pro.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.entity.views.RegularUserView;
import com.pet.pro.mapper.RegularUserMapper;
import com.pet.pro.mapper.RegularUserViewMapper;
import com.pet.pro.service.impl.RegularUserViewServiceImpl;
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

    RegularUserViewServiceImpl regularUserViewServiceImpl;
    @Autowired
    public void setRegularUserViewServiceImpl(RegularUserViewServiceImpl regularUserViewServiceImpl){
        this.regularUserViewServiceImpl = regularUserViewServiceImpl;
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


    @PostMapping("/getUserInfo/{token}")
    public Result<?> getInfo(@PathVariable String token){
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim("username").asString();
        QueryWrapper<RegularUserView> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        RegularUserView regularUserView = regularUserViewMapper.selectOne(wrapper);
        return Result.success(regularUserView,"个人信息");
    }

    @PostMapping("/updateRegularUser")
    public Result<?> updateRegularUser(@RequestBody RegularUserView regularUserView){
        return regularUserViewServiceImpl.updateRegularUser(regularUserView);
    }

}

