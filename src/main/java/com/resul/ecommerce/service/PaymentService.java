package com.resul.ecommerce.service;

import com.resul.ecommerce.dto.CreatePaymentRequestDTO;
import com.resul.ecommerce.dto.CreatePaymentResponse;
import com.resul.ecommerce.dto.StripeResponse;
import com.resul.ecommerce.repository.PaymentRepository;
import com.resul.ecommerce.repository.entity.PaymentStatusEnum;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.*;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;



    @Value("${stripe.secretKey}")
    private String secretKey;

    public StripeResponse createPayment(CreatePaymentRequestDTO createPaymentRequest) {
        // Set your secret key. Remember to switch to your live secret key in production!
        Stripe.apiKey = secretKey;

        Proxy connectionProxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("localhost", 8090));
        Stripe.setConnectionProxy(connectionProxy);


        // Create a PaymentIntent with the order amount and currency
        SessionCreateParams.LineItem.PriceData.ProductData productData =
                SessionCreateParams.LineItem.PriceData.ProductData.builder()
                        .setName(createPaymentRequest.getName())
                        .build();

        // Create new line item with the above product data and associated price
        SessionCreateParams.LineItem.PriceData priceData =
                SessionCreateParams.LineItem.PriceData.builder()
                        .setCurrency(createPaymentRequest.getCurrency())
                        .setUnitAmountDecimal(createPaymentRequest.getAmount())
                        .setProductData(productData)
                        .build();

        // Create new line item with the above price data
        SessionCreateParams.LineItem lineItem =
                SessionCreateParams
                        .LineItem.builder()
                        .setPriceData(priceData)
                        .build();

        // Create new session with the line items
        SessionCreateParams params =
                SessionCreateParams.builder()
                        .setMode(SessionCreateParams.Mode.PAYMENT)
                        .setSuccessUrl(createPaymentRequest.getSuccessUrl())
                        .setCancelUrl(createPaymentRequest.getCancelUrl())
                        .addLineItem(lineItem)
                        .build();

        // Create new session

        Session session;
        try {
            session = Session.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
            return StripeResponse
                    .builder()
                    .status(PaymentStatusEnum.FAILURE.toString())
                    .message("Payment session creation failed")
                    .httpStatus(400)
                    .data(null)
                    .build();
        }

        CreatePaymentResponse responseData = CreatePaymentResponse
                .builder()
                .sessionId(session.getId())
                .sessionUrl(session.getSuccessUrl())
                .build();

        return StripeResponse
                .builder()
                .status(PaymentStatusEnum.SUCCESS.toString())
                .message("Payment session created successfully")
                .httpStatus(200)
                .data(responseData)
                .build();

    }

//    public StripeResponse capturePayment(String sessionId) {
//        Stripe.apiKey = secretKey;
//
//        try {
//            Session session = Session.retrieve(sessionId);
//            String status = session.getPaymentStatus();
//
//            if (status.equalsIgnoreCase(PaymentStatusEnum.STRIPE_SESSION_STATUS_SUCCESS.toString())) {
//                // Handle logic for successful payment
////                log.info("Payment successfully captured.");
//            }
//
//            CapturePaymentResponse responseData = CapturePaymentResponse
//                    .builder()
//                    .sessionId(sessionId)
//                    .sessionStatus(status)
//                    .paymentStatus(session.getPaymentStatus())
//                    .build();
//
//            return StripeResponse
//                    .builder()
//                    .status(PaymentStatusEnum.SUCCESS.toString())
//                    .message("Payment successfully captured.")
//                    .httpStatus(200)
//                    .data(responseData)
//                    .build();
//        } catch (StripeException e) {
//            // Handle capture failure, log the error, and return false
//            e.printStackTrace();
//            return StripeResponse
//                    .builder()
//                    .status(PaymentStatusEnum.FAILURE.toString())
//                    .message("Payment capture failed due to a server error.")
//                    .httpStatus(500)
//                    .data(null)
//                    .build();
//        }
//
//        paymentRepository.save(res)
//    }
}
