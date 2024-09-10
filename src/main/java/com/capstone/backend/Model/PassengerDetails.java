package com.capstone.backend.Model;

import com.capstone.backend.Entity.UserBookings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PassengerDetails {

    private String email;
    private String userName;
    private List<UserBookings> userBookingsList = new ArrayList<>();

    public void setUserBookingsList(UserBookings userBookings) {
        this.userBookingsList.add(userBookings);
    }
}
