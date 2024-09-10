package com.capstone.backend.Controller;

import com.capstone.backend.Entity.UserBookings;
import com.capstone.backend.Model.PassengerDetails;
import com.capstone.backend.Service.Impl.PassengerServiceImpl;
import com.capstone.backend.Service.PassengerService;
import com.capstone.backend.config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/find/passenger")
public class PassengerController {

    @Autowired
    private PassengerServiceImpl passengerService;
    @GetMapping("/profile")
    public PassengerDetails getPassenger(){
        String username = JwtAuthenticationFilter.CURRENT_USER;
        return  passengerService.getPassenger(username);
    }
}
