package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author dreamer
 * @since 2024/12/4
 */
@Data
@TableName("customers")
public class Customer {

    @TableId(value = "customerId", type = IdType.AUTO)
    private Integer customerId;

    @TableField("name")
    private String name;

    @TableField("IDNumber")
    private String IDNumber;

    @TableField("phoneNumber")
    private String phoneNumber;

    @TableField("paymentStatus")
    private String paymentStatus;

}