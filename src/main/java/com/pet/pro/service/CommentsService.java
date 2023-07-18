package com.pet.pro.service;

import com.pet.pro.entity.CommentsEntity;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-17 14:11:59
 */
public interface CommentsService extends IService<CommentsEntity> {

    /**
     * 根据id查询留言
     * @param commentsEntity 留言实体类
     * @return 留言实体类
     * @see com.pet.pro.service.impl.CommentsServiceImpl#updateCommentsById(CommentsEntity)
     */
    public int updateCommentsById(CommentsEntity commentsEntity);
}
