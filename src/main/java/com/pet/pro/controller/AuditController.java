package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.AuditEntity;
import com.pet.pro.service.impl.AuditServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

/**
 * <p>
 * 申请审核表 前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 14:38:03
 */
@RestController
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

