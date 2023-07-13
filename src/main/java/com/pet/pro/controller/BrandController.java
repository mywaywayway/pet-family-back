package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.BrandEntity;
import com.pet.pro.service.impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("BrandController")
@RequestMapping("/brand-entity")
public class BrandController {


    private BrandServiceImpl brandServiceImpl;

    @Autowired
    public void setBrandServiceImpl(BrandServiceImpl brandServiceImpl) {
        this.brandServiceImpl = brandServiceImpl;
    }

    @ResponseBody
    @GetMapping("/GetAllBrand")
    public Result<List<BrandEntity>> GetAllBrand(){
        return Result.success(brandServiceImpl.GetAllBrand());
    }

}

