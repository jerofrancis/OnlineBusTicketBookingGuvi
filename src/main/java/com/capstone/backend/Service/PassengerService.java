package com.capstone.backend.Service;

import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Model.PassengerDetails;

public interface PassengerService {
    PassengerDetails getPassenger(String username);
}
