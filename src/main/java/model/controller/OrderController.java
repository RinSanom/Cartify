package model.controller;

import model.entity.order.Order;
import model.entity.order.OrderStatus;
import model.service.OrderService;

import java.util.List;

public class OrderController {

    private final OrderService orderService;

    public OrderController() {
        this.orderService = new OrderService();
    }

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public Long createOrder(Order order) {
        return orderService.createOrder(order);
    }

    public Long cancelOrder(Long orderId) {
        return orderService.cancelOrder(orderId);
    }

    public Order viewOrderDetails(Long orderId) {
        return orderService.viewOrderDetails(orderId);
    }

    public List<Order> viewUserOrders(Long userId) {
        return orderService.viewUserOrders(userId);
    }

    public Long updateOrderStatus(Long orderId, OrderStatus status) {
        return orderService.updateOrderStatus(orderId, status);
    }
}