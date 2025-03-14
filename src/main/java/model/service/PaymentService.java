package model.service;

import model.entity.Payment;
import model.repository.PaymentRepository;

public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void processPayment(Payment payment) {
        paymentRepository.save(payment);
    }

    public void updatePayment(Payment payment) {
        paymentRepository.update(payment);
    }

    public void deletePayment(int paymentId) {
        paymentRepository.delete(paymentId);
    }

    // Additional payment management methods
}