package com.pet.pro.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pet.pro.entity.OrderFormEntity;
import com.pet.pro.service.OrderFormEntityService;
import com.pet.pro.mapper.OrderFormEntityMapper;
import org.springframework.stereotype.Service;

/**
* @author YehWang
* @description 针对表【order_form】的数据库操作Service实现
* @createDate 2023-07-11 17:17:22
*/
@Service
public class OrderFormEntityServiceImpl extends ServiceImpl<OrderFormEntityMapper, OrderFormEntity>
    implements OrderFormEntityService{

}




