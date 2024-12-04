package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

//用户
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("birthday")
    private Date birthday;
    @TableField("gender")
    private String gender;
    @TableField("username")
    private String username;
    @TableField("password")
    private String password;
    @TableField("remark")
    private String remark;
    @TableField("station")
    private String station;
    @TableField("telephone")
    private String telephone;

    //一对多 关联角色
    @TableField(exist = false)
    private Set<Role> roles;

}
