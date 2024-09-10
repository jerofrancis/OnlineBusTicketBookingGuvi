package com.capstone.backend.Service;

import com.capstone.backend.Dto.TicketResponse;

public interface TicketService {
    TicketResponse getTicket(String passengerId, Integer bookingId);
}
