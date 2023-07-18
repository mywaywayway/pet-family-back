package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.AuditEntity;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.views.ComGoodsView;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.service.AuditService;
import com.pet.pro.service.impl.AuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController("AuditController")
@RequestMapping("/audit-entity")
public class AuditController {

    AuditServiceImpl auditService;
    @Autowired
    public void setAuditService(AuditServiceImpl auditService){
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

    private AuditServiceImpl auditServiceImpl;

    @Autowired
    public void setAuditServiceImpl(AuditServiceImpl auditServiceImpl) {
        this.auditServiceImpl = auditServiceImpl;
    }

    @ResponseBody
    @PostMapping("/insertAudit")
    public Result<?> insertAudit(@RequestBody AuditEntity auditEntity){
       UUID uuid=UUID.randomUUID();
         auditEntity.setId(uuid.toString());
        int  flag=auditServiceImpl.insertAudit(auditEntity);
        if (flag==1){
            return Result.success("申请表添加成功");
        }else {
            return Result.fail("申请表添加失败");
        }
    }

}

