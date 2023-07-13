package com.pet.pro.service.impl;

import com.pet.pro.entity.AuditEntity;
import com.pet.pro.entity.CommodityEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.mapper.AuditMapper;
import com.pet.pro.mapper.ComGoodsMapper;
import com.pet.pro.mapper.CommodityMapper;
import com.pet.pro.mapper.ShopMapper;
import com.pet.pro.service.AuditService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 申请审核表 服务实现类
 * </p>
 *
 * @author  My-way
 * @since 2023-07-12 14:38:03
 */
@Service
public class AuditServiceImpl extends ServiceImpl<AuditMapper, AuditEntity> implements AuditService {



    @Override
    public int insertAudit(AuditEntity auditEntity){
        return baseMapper.insert(auditEntity);
    }

    AuditMapper auditMapper;
    @Autowired
    public void setAuditMapper(AuditMapper auditMapper){
        this.auditMapper = auditMapper;
    }

    CommodityMapper commodityMapper;
    @Autowired
    public void setComGoodsMapper(CommodityMapper commodityMapper){
        this.commodityMapper = commodityMapper;
    }

    ShopMapper shopMapper;
    @Autowired
    public void setShopMapper(ShopMapper shopMapper){
        this.shopMapper = shopMapper;
    }

    //获取审核信息
    public List<AuditEntity> getAuditList() {
        return auditMapper.selectList(null);
    }

    /** DoubleHong
     * 申请通过
     * @param auditEntity 审核实体
     * @param auditPerson 审核人
     * @return 1
     */
    public int passAudit(AuditEntity auditEntity,String auditPerson) {
        auditEntity.setAuditState("审核通过");
        auditEntity.setAuditPerson(auditPerson);
        auditMapper.updateById(auditEntity);
        //如果是商品
        if(Objects.equals(auditEntity.getAuditType(), "商品")){
            //目标商品
            CommodityEntity commodityEntity = commodityMapper.selectById(auditEntity.getKeyWord());
            //修改商品状态
            commodityEntity.setState("上架中");
            commodityMapper.updateById(commodityEntity);
        }//如果是店铺
        else if (Objects.equals(auditEntity.getAuditType(), "店铺")) {
            //目标店铺
            ShopEntity shopEntity = shopMapper.selectById(auditEntity.getKeyWord());
            //修改店铺状态
            shopEntity.setShopStatus("已开业");
            shopMapper.updateById(shopEntity);
        }
        //用户变商家暂时没写
        return 1;
    }

    //申请不通过
    @Override
    public int notPassAudit(AuditEntity auditEntity, String auditPerson) {
        auditEntity.setAuditState("审核未通过");
        auditEntity.setAuditPerson(auditPerson);
        auditMapper.updateById(auditEntity);
        //如果是商品
        if(Objects.equals(auditEntity.getAuditType(), "商品")){
            //目标商品
            CommodityEntity commodityEntity = commodityMapper.selectById(auditEntity.getKeyWord());
            //修改商品状态
            commodityEntity.setState("审核未通过");
            commodityMapper.updateById(commodityEntity);
        }//如果是店铺
        else if (Objects.equals(auditEntity.getAuditType(), "店铺")) {
            //目标店铺
            ShopEntity shopEntity = shopMapper.selectById(auditEntity.getKeyWord());
            //修改店铺状态
            shopEntity.setShopStatus("审核未通过");
            shopMapper.updateById(shopEntity);
        }
        //用户变商家暂时没写
        return 1;
    }



}
