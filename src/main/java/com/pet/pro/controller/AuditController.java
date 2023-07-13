package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.AuditEntity;
import com.pet.pro.service.impl.AuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;


@RestController("AuditController")
@RequestMapping("/audit-entity")
public class AuditController {

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

