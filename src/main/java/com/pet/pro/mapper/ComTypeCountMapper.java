package com.pet.pro.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pet.pro.entity.DTO.ComCount;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/13
 */
@Mapper
public interface ComTypeCountMapper extends BaseMapper<ComCount> {
}
