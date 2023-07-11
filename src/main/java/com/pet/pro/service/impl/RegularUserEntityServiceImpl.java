package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.service.RegularUserEntityService;
import com.pet.pro.mapper.RegularUserEntityMapper;
import org.springframework.stereotype.Service;

/**
* @author YehWang
* @description 针对表【regular_user(普通用户)】的数据库操作Service实现
* @createDate 2023-07-11 17:17:22
*/
@Service
public class RegularUserEntityServiceImpl extends ServiceImpl<RegularUserEntityMapper, RegularUserEntity>
    implements RegularUserEntityService{

}




