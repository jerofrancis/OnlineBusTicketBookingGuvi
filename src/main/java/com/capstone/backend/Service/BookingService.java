package com.capstone.backend.Service;

import com.capstone.backend.Dto.RequestBooking;
import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Model.ReservationResponse;

public interface BookingService {
    ReservationResponse reserveBooking(String userEmail, RequestBooking request);


    Integer getTotalPrice(RequestBooking request);
}
