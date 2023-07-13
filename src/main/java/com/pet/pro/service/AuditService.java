package com.pet.pro.service;

import com.pet.pro.entity.AuditEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 申请审核表 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 11:53:07
 */
public interface AuditService extends IService<AuditEntity> {

    //获取审核信息
    List<AuditEntity> getAuditList();

    //申请通过
    int passAudit(AuditEntity auditEntity,String auditPerson);

    //申请不通过
    int notPassAudit(AuditEntity auditEntity,String auditPerson);
}
