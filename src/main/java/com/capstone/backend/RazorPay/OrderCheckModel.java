package com.capstone.backend.RazorPay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCheckModel {
    public String getRazorpay_signature() {
        return razorpay_signature;
    }

    private String order_id;
    private String payment_id;
    private String razorpay_signature;
}
