package model.repository;

import model.entity.Payment;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PaymentRepositoryImpl implements PaymentRepository {
    // Simulating an in-memory database for demonstration purposes
    private List<Payment> payments = new ArrayList<>();

    @Override
    public Optional<Payment> findById(Integer id) {
        return payments.stream()
                .filter(payment -> payment.getPaymentId() == id)
                .findFirst();
    }

    @Override
    public List<Payment> findAll() {
        return payments;
    }

    @Override
    public void save(Payment entity) {
        payments.add(entity);
    }

    @Override
    public void update(Payment entity) {
        payments = payments.stream()
                .map(payment -> payment.getPaymentId() == entity.getPaymentId() ? entity : payment)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        payments.removeIf(payment -> payment.getPaymentId() == id);
    }

    @Override
    public List<Payment> findByStatus(String status) {
        return payments.stream()
                .filter(payment -> payment.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }
}