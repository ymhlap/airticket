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
@NoArgsConstructor
@AllArgsConstructor
@TableName("customers")
public class Customer  implements Serializable {

    //客户ID
    @ApiModelProperty("主键")
    @TableId(type = IdType.AUTO)
    private Integer customerId;

    //客户姓名
    @TableField("Name")
    private String name;

    //联系方式
    @TableField("ContactInfo")
    private String contactInfo;

    //证件号码
    @TableField("IdNumber")
    private Integer idNumber;

    //支付状态
    @TableField("PaymentStatus")
    private String paymentStatus;

}