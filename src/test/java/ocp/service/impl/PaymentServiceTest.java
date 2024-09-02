package ocp.service.impl;

import ocp.service.PaymentMethod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentMethod creditCardPayment;
    private PaymentMethod paypalPayment;

    @BeforeEach
    void setUp() {
        creditCardPayment = Mockito.mock(PaymentMethod.class);
        paypalPayment = Mockito.mock(PaymentMethod.class);

        paymentService = new PaymentService(List.of(creditCardPayment, paypalPayment));
    }

    @Test
    @Disabled
    void shouldProcessCreditCardPayment() {
        when(creditCardPayment.getClass().getSimpleName()).thenReturn("CreditCardPayment");

        paymentService.processPayment("CreditCardPayment", 100.0);

        verify(creditCardPayment, times(1)).pay(100.0);
    }

    @Test
    @Disabled
    void shouldProcessPaypalPayment() {
        when(paypalPayment.getClass().getSimpleName()).thenReturn("PaypalPayment");

        paymentService.processPayment("PaypalPayment", 150.0);

        verify(paypalPayment, times(1)).pay(150.0);
    }
}
