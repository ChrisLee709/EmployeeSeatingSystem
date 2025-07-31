package com.example.seatingsystem.repository;

import com.example.seatingsystem.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByFloor(Integer floor);
}

