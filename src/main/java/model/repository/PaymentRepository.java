package model.repository;

import model.entity.Payment;
import java.util.List;

public interface PaymentRepository extends GenericRepository<Payment, Integer> {
    List<Payment> findByStatus(String status);
}