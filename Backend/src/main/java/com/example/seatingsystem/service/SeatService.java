package com.example.seatingsystem.service;

import com.example.seatingsystem.entity.Seat;
import com.example.seatingsystem.repository.SeatRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    public List<Seat> getSeatsByFloor(Integer floor) {
        return seatRepository.findByFloor(floor);
    }

    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }
}

