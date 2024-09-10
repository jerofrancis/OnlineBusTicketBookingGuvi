package com.capstone.backend.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestBooking {

    private Integer busId;
    private String date;
    private String source;
    private String destination;
    private List<String> bookedSeats;

}
