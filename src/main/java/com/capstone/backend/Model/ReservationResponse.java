package com.capstone.backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReservationResponse {
    private String date;
    private Integer BookingID;
    private Integer Subtotal;
    private Integer Total;

    @Override
    public String toString() {
        return "ReservationResponse{" +
                "date='" + date + '\'' +
                ", BookingID=" + BookingID +
                ", Subtotal=" + Subtotal +
                ", Total=" + Total +
                '}';
    }
}
