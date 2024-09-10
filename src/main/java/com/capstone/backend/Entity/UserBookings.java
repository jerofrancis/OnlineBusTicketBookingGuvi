package com.capstone.backend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "userBookings")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserBookings {

    @Id
    private ObjectId _id;
    private String email;
    private Integer busId;
    private String name;
    private String source;
    private String destination;
    private Integer bookingId;
    private String departureTime;
    private String arrivalTime;
    private Integer totalPrice;
    private String date;
    private String busType;
    private List<String> reservedSeats = new ArrayList<>();

    public void setReservedSeats(List<String> reservedSeats) {
        this.reservedSeats.addAll(reservedSeats);
    }
}
