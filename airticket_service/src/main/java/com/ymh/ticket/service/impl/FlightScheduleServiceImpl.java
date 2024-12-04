package com.ymh.ticket.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ymh.airticket.entity.Flightschedule;
import com.ymh.ticket.mapper.FlightScheduleMapper;
import com.ymh.ticket.service.FlightScheduleService;
import org.springframework.stereotype.Service;

@Service
public class FlightScheduleServiceImpl extends ServiceImpl<FlightScheduleMapper, Flightschedule> implements FlightScheduleService {
}
