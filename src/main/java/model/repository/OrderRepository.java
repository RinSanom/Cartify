package model.repository;

import model.entity.Order;
import java.util.List;

public interface OrderRepository extends GenericRepository<Order, Integer> {
    List<Order> findByUserId(int userId);
    List<Order> findByStatus(String status);
}