package com.capstone.backend.Dto;

import com.capstone.backend.Entity.UserBookings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketResponse {

    private String userName;

    private UserBookings userBookings;
}
