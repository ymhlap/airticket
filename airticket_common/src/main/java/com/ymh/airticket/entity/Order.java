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

//体检预约信息
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("orders")
public class Order implements Serializable {

    public static final String ORDERTYPE_TELEPHONE = "电话预约";
    public static final String ORDERTYPE_WEIXIN = "微信预约";
    public static final String ORDERSTATUS_YES = "已到诊";
    public static final String ORDERSTATUS_NO = "未到诊";

    //主键
    @TableId(type = IdType.AUTO)
    private Integer id;
    //会员id
    @TableField("member_id")
    private Integer memberId;
    //预约日期
    @TableField("orderDate")
    private LocalDate orderDate;
    //预约类型 电话预约/微信预约
    @TableField("orderType")
    private String orderType;
    //预约状态（是否到诊）
    @TableField("orderStatus")
    private String orderStatus;
    //套餐ID
    @TableField("setmeal_id")
    private Integer setmealId;
    //体检人
    @TableField("id_card")
    private String idCard;

    public Order(Integer memberId, LocalDate orderDate, String orderType, String orderStatus, Integer setmealId , String idCard) {
        this.memberId = memberId;
        this.orderDate = orderDate;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.setmealId = setmealId;
        this.idCard = idCard;
    }

}
