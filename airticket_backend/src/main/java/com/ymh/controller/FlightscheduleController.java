package com.ymh.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymh.airticket.entity.Flightschedule;
import com.ymh.ticket.service.FlightScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/flight-schedules")
public class FlightscheduleController {

    @Autowired
    private FlightScheduleService flightScheduleService;

    @GetMapping("/page")
    public ResponseEntity<Page<Flightschedule>> getFlightSchedulesByPage(
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String departureAirport,
            @RequestParam(required = false) String arrivalAirport,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime startTime,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime endTime) {

        Page<Flightschedule> page = new Page<>(current, size);
        LambdaQueryWrapper<Flightschedule> queryWrapper = new LambdaQueryWrapper<>();

        if (departureAirport != null && !departureAirport.isEmpty()) {
            queryWrapper.eq(Flightschedule::getDepartureAirport, departureAirport);
        }
        if (arrivalAirport != null && !arrivalAirport.isEmpty()) {
            queryWrapper.eq(Flightschedule::getArrivalAirport, arrivalAirport);
        }
        if (startTime != null) {
            queryWrapper.ge(Flightschedule::getDepartureDateTime, startTime);
        }
        if (endTime != null) {
            queryWrapper.le(Flightschedule::getDepartureDateTime, endTime);
        }

        queryWrapper.orderByAsc(Flightschedule::getDepartureDateTime);
        return ResponseEntity.ok(flightScheduleService.page(page, queryWrapper));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flightschedule> getFlightScheduleById(@PathVariable Integer id) {
        return ResponseEntity.ok(flightScheduleService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Boolean> addFlightSchedule(@RequestBody Flightschedule flightSchedule) {
        return ResponseEntity.ok(flightScheduleService.save(flightSchedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateFlightSchedule(
            @PathVariable Integer id,
            @RequestBody Flightschedule flightSchedule) {
        flightSchedule.setScheduleId(id);
        return ResponseEntity.ok(flightScheduleService.updateById(flightSchedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteFlightSchedule(@PathVariable Integer id) {
        return ResponseEntity.ok(flightScheduleService.removeById(id));
    }

    @GetMapping("/flight/{flightId}")
    public ResponseEntity<Page<Flightschedule>> getSchedulesByFlightId(
            @PathVariable Integer flightId,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "10") Integer size) {

        Page<Flightschedule> page = new Page<>(current, size);
        LambdaQueryWrapper<Flightschedule> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Flightschedule::getFlightId, flightId)
                .orderByAsc(Flightschedule::getDepartureDateTime);

        return ResponseEntity.ok(flightScheduleService.page(page, queryWrapper));
    }
}