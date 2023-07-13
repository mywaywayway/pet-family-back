package com.pet.pro.controller;


import com.pet.pro.entity.LoginEntity;
import com.pet.pro.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 登录用户 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 09:32:38
 */
@RestController
@RequestMapping("/login-entity")
public class LoginController {

    LoginMapper loginMapper;
    @Autowired
    public void setLoginMapper(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }

    /** DoubleHong
     * 根据登录编号获取登录信息
     * @param loginId 登录编号
     * @return 登录信息
     */
    @GetMapping("/getLoginInfoById/{loginId}")
    public LoginEntity getLoginInfoById(@PathVariable int loginId){
        return loginMapper.selectById(loginId);
    }

}

