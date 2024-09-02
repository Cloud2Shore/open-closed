package ocp.service.impl;

import ocp.service.PaymentMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final List<PaymentMethod> paymentMethods;

    @Autowired
    public PaymentService(List<PaymentMethod> paymentMethods) {
        this.paymentMethods = paymentMethods;
    }

    public void processPayment(String methodType, double amount) {
        for (PaymentMethod method : paymentMethods) {
            if (method.getClass().getSimpleName().equalsIgnoreCase(methodType)) {
                method.pay(amount);
            }
        }
    }
}
