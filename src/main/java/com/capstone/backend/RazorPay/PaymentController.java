package com.capstone.backend.RazorPay;


import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import static org.apache.commons.codec.digest.HmacUtils.hmacSha256;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Value("${rzp_key_id}")
    private String KeyID;

    @Value("${rzp_key_secret}")
    private String secretKey;

    @PostMapping("/create-order")
    public ResponseEntity<Map<String, String>> Payment(@RequestBody Amount amount) throws RazorpayException{

        RazorpayClient razorpayClient = new RazorpayClient(KeyID,secretKey );

        JSONObject orderRequest = new JSONObject();

        orderRequest.put("amount",amount.getAmount());
        orderRequest.put("currency", "INR");

        Order order = razorpayClient.orders.create(orderRequest);

        Map<String, String> response = new HashMap<>();

        response.put("OrderId", order.get("id"));

        return ResponseEntity.ok(response);
    }

    @PostMapping("/Check-order")
    public boolean CheckPaymentSuccess(@RequestBody OrderCheckModel orderCheck) throws RazorpayException {


        RazorpayClient razorpay = new RazorpayClient(KeyID,secretKey );


        JSONObject options = new JSONObject();
        options.put("razorpay_order_id", orderCheck.getOrder_id());
        options.put("razorpay_payment_id", orderCheck.getPayment_id());
        options.put("razorpay_signature", orderCheck.getRazorpay_signature());


        return Utils.verifyPaymentSignature(options, secretKey);

    }
}
