package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.pro.Result;
import com.pet.pro.entity.LoginEntity;
import com.pet.pro.entity.RegularUserEntity;
import com.pet.pro.entity.views.RegularUserView;
import com.pet.pro.mapper.LoginMapper;
import com.pet.pro.mapper.RegularUserMapper;
import com.pet.pro.service.RegularUserViewService;
import com.pet.pro.mapper.RegularUserViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 10162
* @description 针对表【regular_user_view】的数据库操作Service实现
* @createDate 2023-07-13 09:46:45
*/
@Service
public class RegularUserViewServiceImpl extends ServiceImpl<RegularUserViewMapper, RegularUserView>
    implements RegularUserViewService{


    LoginMapper loginMapper;
    @Autowired
    public void setLoginMapper(LoginMapper loginMapper){
        this.loginMapper = loginMapper;
    }
    RegularUserMapper regularUserMapper;
    @Autowired
    public void setRegularUserMapper(RegularUserMapper regularUserMapper){
        this.regularUserMapper = regularUserMapper;
    }


    @Override
    public Result<?> updateRegularUser(RegularUserView regularUserView) {
        int loginId = regularUserView.getLoginId();
        int regularUserId = regularUserView.getRegularUserId();
        LoginEntity loginEntity = loginMapper.selectById(loginId);
        RegularUserEntity regularUserEntity = regularUserMapper.selectById(regularUserId);
        loginEntity.setGender(regularUserView.getGender());
        loginEntity.setPhone(regularUserView.getPhone());
        loginEntity.setEmail(regularUserView.getEmail());
        regularUserEntity.setBirthday(regularUserView.getBirthday());
        regularUserEntity.setRegularName(regularUserView.getRegularName());
        regularUserEntity.setNickname(regularUserView.getNickname());
        loginMapper.updateById(loginEntity);
        regularUserMapper.updateById(regularUserEntity);
        return Result.success(regularUserView,"success");
    }
}




