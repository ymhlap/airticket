package com.ymh.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymh.airticket.constant.MessageConstant;
import com.ymh.airticket.entity.Customer;
import com.ymh.airticket.result.Result;
import com.ymh.airticket.vo.PageQueryVO;
import com.ymh.ticket.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

/**
 * CheckitemController 检查项接口，仅仅只做接口暴露
 * CheckitemService    检查项业务
 *      CheckitemServiceImpl  检查项业务的具体实现
 * CheckitemMapper     检查项的持久层交互
 *
 * Swagger测试地址：http://localhost:8080/swagger-ui.html
 *
 * @author dreamer
 * @since 2024/12/4
 */
@RestController
@RequestMapping("/admin/customer")
@Api(tags = "客户接口管理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation("分页条件查询检查项")
    @GetMapping("findPage")
    public Result findPage(@ApiParam("分页参数") PageQueryVO vo){
        Page<Customer> page = customerService.findPage(vo);
        if(page!=null){
            return new Result(true , MessageConstant.QUERY_CHECKITEM_SUCCESS , page);
        }
        return new Result(false , MessageConstant.QUERY_CHECKITEM_FAIL);
    }

    @ApiOperation("新增客户")
    @PostMapping("add")
    public Result add(@RequestBody Customer customer){
        boolean flag = customerService.save(customer);
        if(flag){
            return new Result(true , MessageConstant.ADD_CHECKITEM_SUCCESS);
        }
        return new Result(false , MessageConstant.ADD_CHECKITEM_FAIL);
    }

    @ApiOperation("通过ID查询检查项信息")
    @GetMapping("{id}")
    public Result findOne(@PathVariable("id") Integer id){
        Customer customer = customerService.getById(id);
        if(!ObjectUtils.isEmpty(customer)){
            return new Result(true , MessageConstant.QUERY_CHECKITEM_SUCCESS,customer);
        }
        return new Result(false , MessageConstant.QUERY_CHECKITEM_FAIL);
    }

    @ApiOperation("编辑客户")
    @PutMapping("update")
    public Result update(@RequestBody Customer customer){
        boolean flag = customerService.updateById(customer);
        if(flag){
            return new Result(true , MessageConstant.EDIT_CHECKITEM_SUCCESS);
        }
        return new Result(false , MessageConstant.EDIT_CHECKITEM_FAIL);
    }

    @ApiOperation("删除客户")
    @DeleteMapping("{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean flag = customerService.del(id);
        if(flag){
            return new Result(true , MessageConstant.DELETE_CHECKITEM_SUCCESS);
        }
        return new Result(false , MessageConstant.DELETE_CHECKITEM_FAIL);
    }
}
