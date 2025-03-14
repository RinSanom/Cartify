package controller;

import model.entity.Product;
import model.entity.Order;
import model.entity.Payment;
import model.service.AdminService;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    //log in

    //end log in code
    public void addProduct(Product product) {
        adminService.addProduct(product);
    }

    public void updateProduct(Product product) {
        adminService.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        adminService.deleteProduct(productId);
    }

    public List<Order> getAllOrders() {
        return adminService.getAllOrders();
    }

    public Order getOrderById(int orderId) {
        return adminService.getOrderById(orderId);
    }

    public void updateOrderStatus(int orderId, String status) {
        adminService.updateOrderStatus(orderId, status);
    }

    public List<Payment> getAllPayments() {
        return adminService.getAllPayments();
    }

    public Payment getPaymentById(int paymentId) {
        return adminService.getPaymentById(paymentId);
    }

    public void updatePaymentStatus(int paymentId, String status) {
        adminService.updatePaymentStatus(paymentId, status);
    }
}