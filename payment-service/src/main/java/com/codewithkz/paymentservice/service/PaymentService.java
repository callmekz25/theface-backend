package com.codewithkz.paymentservice.service;

import com.codewithkz.commonlibrary.service.BaseService;
import com.codewithkz.paymentservice.model.Payment;
import com.codewithkz.commonlibrary.event.CreatePaymentEvent;

public interface PaymentService extends BaseService<Payment, String> {
    Payment getByOrderId(String id);
    void handleProcessPaymentEvent(CreatePaymentEvent event);
}
