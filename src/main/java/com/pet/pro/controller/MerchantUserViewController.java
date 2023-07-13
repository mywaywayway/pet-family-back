package com.pet.pro.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.views.MerchantUserView;
import com.pet.pro.service.MerchantUserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant-user-view-entity")
@CrossOrigin
public class MerchantUserViewController {
    private MerchantUserViewService merchantUserViewService;

    @Autowired
    public void setMerchantUserViewService(MerchantUserViewService merchantUserViewService){
        this.merchantUserViewService = merchantUserViewService;
    }

    @PostMapping("/getInfo/{token}")
    public Result<?> getInfo(@PathVariable String token){
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim("username").asString();
        QueryWrapper<MerchantUserView> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        MerchantUserView oneInfo = merchantUserViewService.getOne(wrapper);
        return Result.success(oneInfo,"个人信息");
    }
}
