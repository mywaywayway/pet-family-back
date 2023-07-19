package com.pet.pro.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.pet.pro.Result;
import com.pet.pro.entity.CommentsEntity;
import com.pet.pro.entity.ShopEntity;
import com.pet.pro.mapper.CommentsMapper;
import com.pet.pro.mapper.ShopMapper;
import com.pet.pro.service.impl.CommentsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController("CommentsController")
@RequestMapping("/comments-entity")
public class CommentsController {
    @Autowired
    private CommentsMapper commentsMapper;

    @GetMapping("/getComments/{commotityId}")
    public Result<?> getCommentsByCommotityId(@PathVariable Integer commotityId) {
        LambdaQueryWrapper<CommentsEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommentsEntity::getCommodityId, commotityId);
        List<CommentsEntity> commentsEntities = commentsMapper.selectList(queryWrapper);
        if(commentsEntities.size() > 0) {
            return Result.success(commentsEntities);
        }
        else {
            return Result.fail();
        }
    }

    @PostMapping("/addComments")
    public Result<?> addComments(@RequestBody CommentsEntity commentsEntity){
//        System.out.println(commentsEntity);
//        String oldFileName = commentsEntity.getCommentsPhoto();
//        Random r = new Random();
////        String newfilename =commentsEntity.getCommodityId()+"-"+commentsEntity.getOrderId()+oldFileName;
//        String newfilename =commentsEntity.getCommodityId()+"-"+commentsEntity.getOrderId()+".jpg";
//        try{
////阿里云华北2地址
//            String endpoint = "https://oss-cn-beijing.aliyuncs.com";
//
//            String accessKeyId = "LTAI5tSdsiqft5EaFpKXPHpr";
//
//            String accessKeyScret ="2CeQq0HYVWBmus49oGVUaFz7iYtSLA";
//
//            // 创建OSSClient实例。
//            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId,accessKeyScret);
//
//            InputStream inputStream = new FileInputStream(oldFileName);
//
//            ossClient.putObject("xixi0706",newfilename,inputStream);
//
//            ossClient.shutdown();
//        }
//        catch (Exception e){
//            return Result.fail();
//        }
//        commentsEntity.setCommentsPhoto("http://xixi0706.oss-cn-beijing.aliyuncs.com/"+newfilename);

        System.out.println("添加评论");
        System.out.println(commentsEntity);

        if(commentsMapper.insert(commentsEntity)==1){
            return Result.success();
        }
        else{
            return Result.fail();
        }
    }


    private CommentsServiceImpl commentsService;

    @Autowired
    public CommentsController(CommentsServiceImpl commentsService) {
        this.commentsService = commentsService;
    }

    @PostMapping("/updateCommentsById")
    public Result<?> updateCommentsById(@RequestBody CommentsEntity commentsEntity) {
        int flag = commentsService.updateCommentsById(commentsEntity);
        if (flag == 1) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     *
     *
     * @param commodityId 商品id
     * @param orderId 订单id
     * @return Result
     */

    @ApiOperation("查询评价")
    @GetMapping("getComment/{commodityId}/{orderId}")
    public Result<?> getComment(@PathVariable Integer commodityId,@PathVariable Integer orderId){
        QueryWrapper<CommentsEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("commodity_id",commodityId);
        wrapper.eq("order_id",orderId);
        CommentsEntity commentsEntity = commentsService.getOne(wrapper);
        return Result.success(commentsEntity);
    }


}

