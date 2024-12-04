package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

//角色
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("role")
public class Role implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("keyword")
    private String keyword;
    @TableField("description")
    private String description;

    //一对多 关联权限
    @TableField(exist = false)
    private Set<Permission> permissions;
}
