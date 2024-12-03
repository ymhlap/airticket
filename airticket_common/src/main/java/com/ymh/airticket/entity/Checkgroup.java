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

//检查组
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("checkgroup")
public class Checkgroup implements Serializable {

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //检查组编号
    @TableField("code")
    private String code;
    //检查组名称
    @TableField("name")
    private String name;
    //助记编码
    @TableField("helpCode")
    private String helpCode;
    //适用性别
    @TableField("sex")
    private String sex;
    //备注
    @TableField("remark")
    private String remark;
    //注意事项
    @TableField("attention")
    private String attention;

    //检查组包含多个检查项，多对多关系
    @TableField(exist = false)
    private List<Checkitem> checkitems;
}
