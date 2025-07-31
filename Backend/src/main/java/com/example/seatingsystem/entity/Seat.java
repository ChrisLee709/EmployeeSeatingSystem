package com.example.seatingsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer floor;

    private Integer rowNumber;

    private Integer columnNumber;

    private Integer employeeId;

    public Seat() {}

    public Seat(Integer floor, Integer rowNumber, Integer columnNumber, Integer employeeId) {
        this.floor = floor;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }
    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRowNumber() {
        return rowNumber;
    }
    public void setRowNumber(Integer rowNumber) {
        this.rowNumber = rowNumber;
    }

    public Integer getColumnNumber() {
        return columnNumber;
    }
    public void setColumnNumber(Integer columnNumber) {
        this.columnNumber = columnNumber;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}


