package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//会员信息
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("member")
public class Member implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @TableField("fileNumber")
    private String fileNumber;
    @TableField("name")
    private String name;
    @TableField("sex")
    private String sex;
    @TableField("idCard")
    private String idCard;
    @TableField("phoneNumber")
    private String phoneNumber;
    @TableField("regTime")
    private LocalDateTime regTime;
    @TableField("password")
    private String password;
    @TableField("email")
    private String email;
    @TableField("birthday")
    private LocalDate birthday;
    @TableField("remark")
    private String remark;

    public Member(String name, String sex, String idCard, String phoneNumber, LocalDateTime regTime) {
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.regTime = regTime;
    }
}
