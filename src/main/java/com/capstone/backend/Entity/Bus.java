package com.capstone.backend.Entity;

import com.capstone.backend.Model.SeatLayout;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;
@Document(collection = "buses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bus {
    @Id
    private ObjectId _id;
    private Integer id;
    private String name;
    private String source;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private Integer price;
    private String busType;
    private Integer numberOfSeats;
    private SeatLayout seatLayout;
}
