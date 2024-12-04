package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName flightschedule
 */
@TableName(value ="flightschedule")
@Data
public class Flightschedule implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer scheduleid;

    /**
     * 
     */
    private Integer flightid;

    /**
     * 
     */
    private String departureairport;

    /**
     * 
     */
    private String arrivalairport;

    /**
     * 
     */
    private Date departuredatetime;

    /**
     * 
     */
    private Date arrivaldatetime;

    /**
     * 
     */
    private Date flightduration;


}