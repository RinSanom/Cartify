package model.service;

import model.entity.order.Order;
import model.entity.order.OrderStatus;
import model.repository.order.OrderRepository;
import model.repository.OrderRepositoryImpl;

import java.util.List;

public class OrderService {

    private final OrderRepository<Order, Long> orderRepository;

    public OrderService() {
        this.orderRepository = new OrderRepositoryImpl();
    }

    public OrderService(OrderRepository<Order, Long> orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long createOrder(Order order) {
        return orderRepository.createOrder(order);
    }

    public Long cancelOrder(Long orderId) {
        return orderRepository.cancelOrder(orderId);
    }

    public Order viewOrderDetails(Long orderId) {
        return orderRepository.viewOrderDetails(orderId);
    }

    public List<Order> viewUserOrders(Long userId) {
        return orderRepository.viewUserOrders(userId);
    }

    public Long updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepository.viewOrderDetails(orderId);
        if (order != null) {
            order.setOrderStatus(status);
        }
        return orderId;
    }
}