package com.capstone.backend.Service.Impl;

import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Model.PassengerDetails;
import com.capstone.backend.Repository.UserBookingsRepo;
import com.capstone.backend.Service.PassengerService;
import com.capstone.backend.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    private UserBookingsRepo userBookingsRepo;

    @Autowired
    private UserRepository userRepository;
    @Override
    public PassengerDetails getPassenger(String username) {
        List<UserBookings> userBookingsList = userBookingsRepo.findAllByEmail(username);

        String userName = userRepository.findNameByEmail(username);
        PassengerDetails passengerDetails = new PassengerDetails();

        passengerDetails.setEmail(username);
        passengerDetails.setUserName(userName);

        for (UserBookings u: userBookingsList) {
            passengerDetails.setUserBookingsList(u);
        }
        return passengerDetails;
    }
}
