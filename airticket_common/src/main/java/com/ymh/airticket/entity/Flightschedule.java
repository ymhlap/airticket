package com.ymh.airticket.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@TableName("flightschedule")
public class Flightschedule {
    @TableId(value = "ScheduleID", type = IdType.AUTO)
    private Integer scheduleId;

    @TableField("FlightID")
    private Integer flightId;

    @TableField("DepartureAirport")
    private String departureAirport;

    @TableField("ArrivalAirport")
    private String arrivalAirport;

    @TableField("DepartureDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime departureDateTime;

    @TableField("ArrivalDateTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalDateTime;

    @TableField("FlightDuration")
    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime flightDuration;
}