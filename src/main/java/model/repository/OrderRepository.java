package model.repository;

import model.entity.order.Order;
import model.entity.order.OrderStatus;
import model.repository.order.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderRepositoryImpl implements OrderRepository<Order, Long> {
    private final List<Order> orderDatabase = new ArrayList<>();

    @Override
    public Long createOrder(Order order) {
        orderDatabase.add(order);
        return order.getOderId();
    }

    @Override
    public Long cancelOrder(Long orderId) {
        Optional<Order> order = orderDatabase.stream()
                .filter(o -> o.getOderId() == orderId)
                .findFirst();
        order.ifPresent(o -> o.setOrderStatus(OrderStatus.CANCELLED));
        return orderId;
    }

    @Override
    public Order viewOrderDetails(Long orderId) {
        return orderDatabase.stream()
                .filter(o -> o.getOderId() == orderId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> viewUserOrders(Long userId) {
        return orderDatabase.stream()
                .filter(o -> o.getUserId().getId() == userId)
                .toList();
    }
}
