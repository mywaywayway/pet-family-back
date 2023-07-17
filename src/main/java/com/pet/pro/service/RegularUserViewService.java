package com.pet.pro.service;

import com.pet.pro.Result;
import com.pet.pro.entity.views.RegularUserView;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 10162
* @description 针对表【regular_user_view】的数据库操作Service
* @createDate 2023-07-13 09:46:45
*/
public interface RegularUserViewService extends IService<RegularUserView> {

    Result<?> updateRegularUser(RegularUserView regularUserView);
}
