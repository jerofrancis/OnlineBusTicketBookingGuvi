package com.capstone.backend.Controller;


import com.capstone.backend.Dto.RequestBooking;
import com.capstone.backend.Model.ReservationResponse;
import com.capstone.backend.Service.Impl.BookingServiceImpl;
import com.capstone.backend.config.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
public class BookingController {

    @Autowired
    private BookingServiceImpl bookingService;
    @PutMapping("/store")
    public ReservationResponse reservation(@RequestBody RequestBooking request){
        String UserEmail = JwtAuthenticationFilter.CURRENT_USER;
        ReservationResponse res = bookingService.reserveBooking(UserEmail,request);
        return res;
    }

    @PostMapping("/get/total-price")
    public Integer getTotalPrice(@RequestBody RequestBooking request){
        return bookingService.getTotalPrice(request);
    }
}
