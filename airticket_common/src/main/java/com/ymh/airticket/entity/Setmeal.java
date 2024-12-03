package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

//体检套餐
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("setmeal")
public class Setmeal implements Serializable {
    //套餐ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //套餐名称
    @TableField("name")
    private String name;
    //套餐编号
    @TableField("code")
    private String code;
    //助记码
    @TableField("helpCode")
    private String helpCode;
    //适用性别 0不限 1男 2女
    @TableField("sex")
    private String sex;
    //适用年龄范围
    @TableField("age")
    private String age;
    //套餐价格
    @TableField("price")
    private Float price;
    //备注
    @TableField("remark")
    private String remark;
    //注意事项
    @TableField("attention")
    private String attention;
    //套餐图片存储路径
    @TableField("img")
    private String img;

    //体检套餐对应的检查组，多对多关系
    @TableField(exist = false)
    private List<Checkgroup> checkgroups;
}
