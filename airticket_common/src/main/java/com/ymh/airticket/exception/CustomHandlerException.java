package com.ymh.airticket.exception;

import com.ymh.airticket.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author chemin
 * @since 2024/7/4
 */
@RestControllerAdvice
public class CustomHandlerException {

    @ExceptionHandler
    public Result exHandler1(AirticketException ex){
        return new Result(false , ex.getMessage());
    }

    /*@ExceptionHandler
    public Result exHandler2(Exception ex){
        ex.printStackTrace();
        return new Result(false , "内部错误");
    }*/

}
