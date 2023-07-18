package com.pet.pro.service.impl;

import com.pet.pro.entity.CommentsEntity;
import com.pet.pro.mapper.CommentsMapper;
import com.pet.pro.service.CommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-17 14:11:59
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, CommentsEntity> implements CommentsService {


    @Override
    public int updateCommentsById(CommentsEntity commentsEntity) {
        return baseMapper.updateById(commentsEntity);
    }
}
