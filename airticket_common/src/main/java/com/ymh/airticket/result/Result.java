package com.ymh.airticket.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author chenmin
 * @Description 封装通用返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("统一结果集")
public class Result implements Serializable {

    @ApiModelProperty("返回执行结果，true为执行成功 false为执行失败")
    private boolean flag;

    @ApiModelProperty("返回提示信息，主要用于页面提示信息")
    private String message;

    @ApiModelProperty("返回数据")
    private Object data;

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

}
