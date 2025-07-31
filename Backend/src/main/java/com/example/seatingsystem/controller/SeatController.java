package com.example.seatingsystem.controller;

import com.example.seatingsystem.entity.Seat;
import com.example.seatingsystem.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    // 取得指定樓層所有座位
    @GetMapping("/floor/{floor}")
    public List<Seat> getSeatsByFloor(@PathVariable Integer floor) {
        return seatService.getSeatsByFloor(floor);
    }

    // 新增或更新座位資料
    @PostMapping
    public Seat saveSeat(@RequestBody Seat seat) {
        return seatService.saveSeat(seat);
    }
}

