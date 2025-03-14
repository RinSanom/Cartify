package model.service;

import model.entity.Product;
import model.entity.Order;
import model.entity.Payment;
import model.repository.ProductRepository;
import model.repository.OrderRepository;
import model.repository.PaymentRepository;

import java.util.List;

public class AdminService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public AdminService(ProductRepository productRepository, OrderRepository orderRepository, PaymentRepository paymentRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.update(product);
    }

    public void deleteProduct(int productId) {
        productRepository.delete(productId);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(int orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public void updateOrderStatus(int orderId, String status) {
        Order order = orderRepository.findById(orderId).orElse(null);
        if (order != null) {
            order.setStatus(status);
            orderRepository.update(order);
        }
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId).orElse(null);
    }

    public void updatePaymentStatus(int paymentId, String status) {
        Payment payment = paymentRepository.findById(paymentId).orElse(null);
        if (payment != null) {
            payment.setStatus(status);
            paymentRepository.update(payment);
        }
    }
}