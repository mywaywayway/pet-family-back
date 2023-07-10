package com.pet.pro.service.impl;

import com.pet.pro.entity.LoginEntity;
import com.pet.pro.mapper.LoginMapper;
import com.pet.pro.service.LoginService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-10 17:35:14
 */
@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, LoginEntity> implements LoginService {

}
