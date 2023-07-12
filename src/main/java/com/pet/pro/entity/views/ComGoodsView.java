package com.pet.pro.entity.views;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/11
 */
@Data
@TableName(value ="com_goods")
@ApiModel(value = "ComGoodsView对象", description = "商品信息视图")
public class ComGoodsView implements Serializable {
    /**
     * 商品id
     */
    private Integer id;

    /**
     * 品牌名称
     */
    private String brandName;

    /**
     * 类别名称
     */
    private String typeName;

    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 商品价格
     */
    private Double price;

    /**
     * 商品图片
     */
    private String photo;

    /**
     * 商品介绍
     */
    private String introduce;

    /**
     * 销量
     */
    private Integer saleVolume;
    /**
     * 店铺名称
     */
    private String shopName;
    /**
     * 店铺id
     */
    private Integer shopId;

    /**
     * 商品状态
     */
    private String state;

}
