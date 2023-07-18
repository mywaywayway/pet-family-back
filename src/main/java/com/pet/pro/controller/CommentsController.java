package com.pet.pro.controller;


import com.pet.pro.Result;
import com.pet.pro.entity.CommentsEntity;
import com.pet.pro.service.impl.CommentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author  My-way
 * @since 2023-07-17 14:11:59
 */
@RestController
@RequestMapping("/comments-entity")
public class CommentsController {


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

}

