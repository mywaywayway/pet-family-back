package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.yulichang.query.MPJLambdaQueryWrapper;
import com.github.yulichang.query.MPJQueryWrapper;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.pet.pro.entity.DTO.MerchantUser;
import com.pet.pro.entity.LoginEntity;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.service.RegularUserEntityService;
import com.pet.pro.mapper.RegularUserEntityMapper;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author YehWang
* @description 针对表【regular_user(普通用户)】的数据库操作Service实现
* @createDate 2023-07-11 17:17:22
*/
@Service
public class RegularUserEntityServiceImpl extends ServiceImpl<RegularUserEntityMapper, RegularUserEntity>
    implements RegularUserEntityService{

    private RegularUserEntityMapper regularUserMapper;
    @Autowired
    public void setRegularUserEntityMapper(RegularUserEntityMapper regularUserEntityMapper) {
        this.regularUserMapper = regularUserEntityMapper;
    }

}
