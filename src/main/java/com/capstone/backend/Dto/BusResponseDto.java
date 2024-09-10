package com.capstone.backend.Dto;

import com.capstone.backend.Entity.Bookings;
import com.capstone.backend.Model.SeatLayout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusResponseDto {
    private Integer id;
    private String name;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String price;
    private String busType;
    private Integer numberOfSeats;
    private SeatLayout seatLayout;
    private Bookings bookings;
}
