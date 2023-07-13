package com.pet.pro.service;

import com.pet.pro.entity.AuditEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 申请审核表 服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 14:38:03
 */
public interface AuditService extends IService<AuditEntity> {

    /**
     * 插入一条审核记录
     * @param auditEntity 审核记录
     * @return 是否成功
     * @see com.pet.pro.service.impl.AuditServiceImpl#insertAudit(AuditEntity)
     */
    int insertAudit(AuditEntity auditEntity);


}
