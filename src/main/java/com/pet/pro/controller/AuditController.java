package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.AuditEntity;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 申请审核表 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:53:07
 */
@RestController
@RequestMapping("/audit-entity")
public class AuditController {

    AuditService auditService;
    @Autowired
    public void setAuditService(AuditService auditService){
        this.auditService = auditService;
    }

    CommodityMapper commodityMapper;
    @Autowired
    public void setCommodityMapper(CommodityMapper commodityMapper){
        this.commodityMapper = commodityMapper;
    }

    ComGoodsMapper comGoodsMapper;
    @Autowired
    public void setComGoodsMapper(ComGoodsMapper comGoodsMapper){
        this.comGoodsMapper = comGoodsMapper;
    }

    /** DoubleHong
     * 获取审核信息
     * @return 审核信息列表
     */
    @GetMapping("/getAuditList")
    public Result<List<AuditEntity>> getAuditList(){
        return Result.success(auditService.getAuditList());
    }


    //申请通过
    @PostMapping("/passAudit/{auditPerson}")
    public Result<List<AuditEntity>> passAudit(@RequestBody AuditEntity auditEntity, @PathVariable String auditPerson){
        auditService.passAudit(auditEntity,auditPerson);
        return Result.success(auditService.getAuditList());
    }

    //申请不通过
    @PostMapping("/notPassAudit/{auditPerson}")
    public Result<List<AuditEntity>> notPassAudit(@RequestBody AuditEntity auditEntity, @PathVariable String auditPerson){
        auditService.notPassAudit(auditEntity,auditPerson);
        return Result.success(auditService.getAuditList());
    }

    /**
     * 通过商品ID获取商品信息
     * @param id 商品ID
     * @return 目标商品
     */
    @GetMapping("/getCommodityById/{id}")
    public Result<CommodityEntity> getCommodityById(@PathVariable String id){
        return Result.success(commodityMapper.selectById(id));
    }

    @GetMapping("/getComGoodsById/{id}")
    public Result<ComGoodsView> getComGoodsById(@PathVariable String id){
        return Result.success(comGoodsMapper.selectById(id));
    }

}

