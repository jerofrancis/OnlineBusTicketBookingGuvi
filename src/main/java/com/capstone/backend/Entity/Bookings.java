package com.capstone.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "bookings")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bookings {

    @Id
    private ObjectId _id;

    private Integer bookingId;
    private Integer busId;
    private String date;
    private List<String> bookedSeats = new ArrayList<>();

    public void setBookedSeats(List<String> bookedSeats) {

        this.bookedSeats.addAll(bookedSeats);
    }

}
