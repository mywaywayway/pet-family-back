package com.pet.pro.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.AdministratorEntity;
import com.pet.pro.entity.LoginEntity;
import com.pet.pro.entity.MerchantUserEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.entity.views.AdminUserView;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.entity.views.MerchantUserView;
import com.pet.pro.entity.views.RegularUserView;
import com.pet.pro.mapper.*;
import com.pet.pro.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("AdministratorController")
@RequestMapping("/administrator-entity")
public class AdministratorController {

    MerchantUserViewMapper merchantUserViewMapper;

    @Autowired
    public void setMerchantUserViewMapper(MerchantUserViewMapper merchantUserViewMapper) {
        this.merchantUserViewMapper = merchantUserViewMapper;
    }

    ShopMapper shopMapper;

    @Autowired
    public void setShopMapper(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    LoginMapper loginMapper;

    @Autowired
    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    AdministratorMapper administratorMapper;

    @Autowired
    public void setAdministratorMapper(AdministratorMapper administratorMapper) {
        this.administratorMapper = administratorMapper;
    }

    ComGoodsMapper comGoodsMapper;

    @Autowired
    public void setComGoodsMapper(ComGoodsMapper comGoodsMapper) {

        this.comGoodsMapper = comGoodsMapper;
    }

    AdministratorService administratorService;

    @Autowired
    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }

    AdminUserViewMapper adminUserViewMapper;

    @Autowired
    public void setAdminUserViewMapper(AdminUserViewMapper adminUserViewMapper) {
        this.adminUserViewMapper = adminUserViewMapper;
    }

    /**
     * DoubleHong
     * 获取所有商家用户视图
     *
     * @return 所有商家用户视图
     */
    @GetMapping("/getAllMerchantUser")
    public Result<List<MerchantUserView>> getAllMerchantUser() {
        return Result.success(merchantUserViewMapper.selectList(null));
    }

    @GetMapping("/getAllShopByMerchantId/{merchantId}")
    public Result<List<ShopEntity>> getAllShopByMerchantId(@PathVariable String merchantId) {
        return Result.success(shopMapper.selectList(new QueryWrapper<ShopEntity>().eq("merchant_id", merchantId)));
    }


    @GetMapping("/getComGoodsByShopId/{shopId}")
    public Result<List<ComGoodsView>> getComGoodsByShopId(@PathVariable String shopId) {
        return Result.success(comGoodsMapper.selectList(new QueryWrapper<ComGoodsView>().eq("shop_id", shopId)));
    }

    @GetMapping("/takeOffCommodityById/{commodityId},{currentShopId}")
    public Result<List<ComGoodsView>> takeOffCommodityById(@PathVariable int commodityId, @PathVariable int currentShopId) {
        return administratorService.takeOffCommodityById(commodityId, currentShopId);
    }

    @GetMapping("/closeShopById/{shopId},{currentMerchantId}")
    public Result<List<ShopEntity>> closeShopById(@PathVariable int shopId, @PathVariable int currentMerchantId) {
        return administratorService.closeShopById(shopId, currentMerchantId);
    }


    @PostMapping("/getUserInfo/{token}")
    public Result<?> getInfo(@PathVariable String token) {
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim("username").asString();
        QueryWrapper<AdminUserView> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        AdminUserView adminUserView = adminUserViewMapper.selectOne(wrapper);
        return Result.success(adminUserView, "个人信息");
    }

    @PostMapping("/updateAdminInfo")
    public Result<?> updateAdminInfo(@RequestBody AdminUserView adminUserView) {
        return administratorService.updateAdmin(adminUserView);
    }

}

