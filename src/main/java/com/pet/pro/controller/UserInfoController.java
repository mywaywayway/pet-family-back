package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.UserInfoEntity;
import com.pet.pro.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 18:51:02
 */
@RestController
@RequestMapping("/user-info-entity")
public class UserInfoController {

    //Mapper对象命名与Mapper类名一致,第一个单词小写
    UserInfoMapper userInfoMapper;
    //写每个Mapper的构造函数
    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper){
        this.userInfoMapper = userInfoMapper;
    }

    /**
     * 这是Test函数
     * @param id 用户id
     * @return 用户信息列表
     */
    @ResponseBody
    @GetMapping("/testUser/{id}")
    //函数名 testUser 驼峰命名
    public Result<List<UserInfoEntity>> testUser(@PathVariable String id){
        UserInfoEntity _userInfo = userInfoMapper.selectById(id);//临时变量前加下划线
        List<UserInfoEntity> list = userInfoMapper.selectList(null);
        Result<UserInfoEntity> result = new Result<>();
        result.setCode(200);
        result.setData(_userInfo);
        return Result.success(list);
    }

}

