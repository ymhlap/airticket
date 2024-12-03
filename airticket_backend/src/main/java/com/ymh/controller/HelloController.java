package com.ymh.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author ymh
 * @since 2024/12/3
 */

//当前接口返回的都是json数据格式
@RestController
//窄化请求
@RequestMapping("/test")
//Swagger接口
@Api(tags = "HelloWorld文档接口")
public class HelloController {

    @GetMapping("hello")
    public String hello(){
        return "Hello AirTicket~";
    }
}
