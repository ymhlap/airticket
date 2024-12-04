package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("检查项")
@TableName("checkitem")
public class Checkitem implements Serializable {

    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("项目编号")
    @TableField("code")
    private String code;

    @ApiModelProperty("项目名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("适用性别 0通用 1男性 2女性")
    @TableField("sex")
    private String sex;

    @ApiModelProperty("适用年龄范围，例如：1-100")
    @TableField("age")
    private String age;

    @ApiModelProperty("价格")
    @TableField("price")
    private Float price;

    @ApiModelProperty("查检项类型  1检查 2检验")
    @TableField("type")
    private String type;

    @ApiModelProperty("注意事项")
    @TableField("attention")
    private String attention;

    @ApiModelProperty("项目说明")
    @TableField("remark")
    private String remark;
}
