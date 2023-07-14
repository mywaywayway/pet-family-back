package com.pet.pro.utils;

import com.pet.pro.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @description : 全局异常处理
 * @author : Yaxin-Wang
 * @version : v1.0.0
 * @since : 2023/7/11
 */
@ControllerAdvice
public class GlobalAdviceHandler {

    /**
     * @description : 全局异常处理
     * @param e : 异常
     *          @return : com.pet.pro.utils.Result<?>
     */
     @ExceptionHandler
     public Result<?> exceptionHandler(Exception e){
         e.printStackTrace();
         return Result.fail("服务器异常");
     }

}
