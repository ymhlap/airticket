package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

//预约设置
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("ordersetting")
public class Ordersetting implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    //预约日期
    @TableField("orderDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate orderDate;

    //可预约人数
    @TableField("number")
    private Integer number;

    //已预约人数
    @TableField("reservations")
    private Integer reservations;

    public Ordersetting(LocalDate orderDate ,Integer number){
        this.orderDate = orderDate;
        this.number = number;
    }

    public Ordersetting(LocalDate orderDate ,Integer number,Integer reservations){
        this.orderDate = orderDate;
        this.number = number;
        this.reservations = reservations;
    }

}
