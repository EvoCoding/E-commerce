package com.resul.ecommerce.controller;

import com.resul.ecommerce.dto.CreatePaymentRequestDTO;
import com.resul.ecommerce.dto.StripeResponse;
import com.resul.ecommerce.service.PaymentService;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/stripe")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/create-payment")
    public ResponseEntity<StripeResponse> createPayment(@RequestBody CreatePaymentRequestDTO createPaymentRequest) {
        StripeResponse stripeResponse = paymentService.createPayment(createPaymentRequest);
        return ResponseEntity.status(stripeResponse.getHttpStatus()).body(stripeResponse);
    }

//    @GetMapping("/capture-payment")
//    public ResponseEntity<StripeResponse> capturePayment(@RequestParam String sessionId) {
//        StripeResponse stripeResponse = paymentService.capturePayment(sessionId);
//        return ResponseEntity
//                .status(stripeResponse.getHttpStatus())
//                .body(stripeResponse);
//    }
}
