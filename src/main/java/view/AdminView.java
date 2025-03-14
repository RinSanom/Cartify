package view;

import model.entity.Product;
import model.entity.Order;
import model.entity.Payment;
import controller.AdminController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class AdminView {
    private final AdminController adminController;

    private final Scanner scanner;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Orders");
            System.out.println("3. Manage Payments");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageOrders();
                    break;
                case 3:
                    managePayments();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    public void manageOrders() {
            System.out.println("\nOrders Management");
            System.out.println("1. View All Orders");
            System.out.println("2. View Order by ID");
            System.out.println("3. Update Order Status");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAllOrders();
                    break;
                case 2:
                    viewOrderById();
                    break;
                case 3:
                    updateOrderStatus();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    public void managePayments() {
        System.out.println("\nPayment Management");
        System.out.println("1. View All Payments");
        System.out.println("2. View Payment by ID");
        System.out.println("3. Update Payment Status");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                viewAllPayments();
                break;
            case 2:
                viewPaymentById();
                break;
            case 3:
                updatePaymentStatus();
                break;
            case 4:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void viewAllOrders() {
        System.out.println("\nAll Orders:");
        List<Order> orders = adminController.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders found.");
        } else {
            // Print table header
            System.out.println("+------------+------------+--------------+------------+---------------------+");
            System.out.println("| Order ID   | User ID    | Total Amount | Status     | Created At          |");
            System.out.println("+------------+------------+--------------+------------+---------------------+");

            // Print each order as a row in the table
            for (Order order : orders) {
                System.out.printf(
                        "| %-10d | %-10d | %-12.2f | %-10s | %-19s |\n",
                        order.getOrderId(),
                        order.getUserId(),
                        order.getTotalAmount(),
                        order.getStatus(),
                        order.getCreatedAt()
                );
            }

            // Print table footer
            System.out.println("+------------+------------+--------------+------------+---------------------+");
        }
    }


    private void viewOrderById() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Order order = adminController.getOrderById(orderId);
        if (order != null) {
            System.out.println("\nOrder Details:");
            System.out.println("+------------+------------+--------------+------------+---------------------+");
            System.out.println("| Order ID   | User ID    | Total Amount | Status     | Created At          |");
            System.out.println("+------------+------------+--------------+------------+---------------------+");
            System.out.printf(
                    "| %-10d | %-10d | %-12.2f | %-10s | %-19s |\n",
                    order.getOrderId(),
                    order.getUserId(),
                    order.getTotalAmount(),
                    order.getStatus(),
                    order.getCreatedAt()
            );
            System.out.println("+------------+------------+--------------+------------+---------------------+");
        } else {
            System.out.println("Order not found.");
        }
    }


    private void updateOrderStatus() {
        System.out.print("Enter Order ID: ");
        int orderId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter New Status (PENDING, PAID, DELIVERED): ");
        String status = scanner.nextLine();

        adminController.updateOrderStatus(orderId, status);
        System.out.println("Order status updated successfully.");
    }


    private void viewAllPayments() {
        System.out.println("\nAll Payments:");
        List<Payment> payments = adminController.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            // Print table header
            System.out.println("+------------+------------+--------------+----------------+---------------------+");
            System.out.println("| Payment ID | User ID    | Amount       | Payment Method | Transaction Date    |");
            System.out.println("+------------+------------+--------------+----------------+---------------------+");

            // Print each payment as a row in the table
            for (Payment payment : payments) {
                System.out.printf(
                        "| %-10d | %-10d | %-12.2f | %-14s | %-19s |\n",
                        payment.getPaymentId(),
                        payment.getUserId(),
                        payment.getAmount(),
                        payment.getPaymentMethod(),
                        payment.getTransactionDate()
                );
            }

            // Print table footer
            System.out.println("+------------+------------+--------------+----------------+---------------------+");
        }
    }

    private void viewPaymentById() {
        System.out.print("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Payment payment = adminController.getPaymentById(paymentId);
        if (payment != null) {
            System.out.println("\nPayment Details:");
            System.out.println("+------------+------------+--------------+----------------+---------------------+");
            System.out.println("| Payment ID | User ID    | Amount       | Payment Method | Transaction Date    |");
            System.out.println("+------------+------------+--------------+----------------+---------------------+");
            System.out.printf(
                    "| %-10d | %-10d | %-12.2f | %-14s | %-19s |\n",
                    payment.getPaymentId(),
                    payment.getUserId(),
                    payment.getAmount(),
                    payment.getPaymentMethod(),
                    payment.getTransactionDate()
            );
            System.out.println("+------------+------------+--------------+----------------+---------------------+");
        } else {
            System.out.println("Payment not found.");
        }
    }
    private void updatePaymentStatus() {
        System.out.print("Enter Payment ID: ");
        int paymentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter New Status (PENDING, PAID, DELIVERED): ");
        String status = scanner.nextLine();

        adminController.updatePaymentStatus(paymentId, status);
        System.out.println("Payment status updated successfully.");
    }

    private void manageProducts() {
        System.out.println("\nProduct Management:");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Delete Product");
        System.out.print("Choose an option: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                updateProduct();
                break;
            case 3:
                deleteProduct();
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter stock quantity: ");
        int stockQuantity = scanner.nextInt();
        System.out.print("Enter category ID: "); // Add this line
        int categoryId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setCategoryId(categoryId);
        product.setCreatedAt(LocalDateTime.now());

        adminController.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new product price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter new stock quantity: ");
        int stockQuantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Product product = new Product();
        product.setProductId(productId);
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);

        adminController.updateProduct(product);
        System.out.println("Product updated successfully.");
    }

    private void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        adminController.deleteProduct(productId);
        System.out.println("Product deleted successfully.");
    }

//    private void manageOrders() {
//        System.out.println("\nOrder Management:");
//        System.out.println("1. Create Order");
//        System.out.println("2. Update Order");
//        System.out.println("3. Delete Order");
//        System.out.print("Choose an option: ");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        switch (choice) {
//            case 1:
//                createOrder();
//                break;
//            case 2:
//                updateOrder();
//                break;
//            case 3:
//                deleteOrder();
//                break;
//            default:
//                System.out.println("Invalid option.");
//        }
//    }
//
//    private void createOrder() {
//        System.out.print("Enter user ID: ");
//        int userId = scanner.nextInt();
//        System.out.print("Enter total amount: ");
//        double totalAmount = scanner.nextDouble();
//        scanner.nextLine(); // Consume newline
//
//        Order order = new Order();
//        order.setUserId(userId);
//        order.setTotalAmount(totalAmount);
//
//        adminController.createOrder(order);
//        System.out.println("Order created successfully.");
//    }
//
//    private void updateOrder() {
//        System.out.print("Enter order ID to update: ");
//        int orderId = scanner.nextInt();
//        System.out.print("Enter new total amount: ");
//        double totalAmount = scanner.nextDouble();
//        scanner.nextLine(); // Consume newline
//
//        Order order = new Order();
//        order.setOrderId(orderId);
//        order.setTotalAmount(totalAmount);
//
//        adminController.updateOrder(order);
//        System.out.println("Order updated successfully.");
//    }
//
//    private void deleteOrder() {
//        System.out.print("Enter order ID to delete: ");
//        int orderId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        adminController.deleteOrder(orderId);
//        System.out.println("Order deleted successfully.");
//    }
//
//    private void managePayments() {
//        System.out.println("\nPayment Management:");
//        System.out.println("1. Process Payment");
//        System.out.println("2. Update Payment");
//        System.out.println("3. Delete Payment");
//        System.out.print("Choose an option: ");
//
//        int choice = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        switch (choice) {
//            case 1:
//                processPayment();
//                break;
//            case 2:
//                updatePayment();
//                break;
//            case 3:
//                deletePayment();
//                break;
//            default:
//                System.out.println("Invalid option.");
//        }
//    }
//
//    private void processPayment() {
//        System.out.print("Enter user ID: ");
//        int userId = scanner.nextInt();
//        System.out.print("Enter amount: ");
//        double amount = scanner.nextDouble();
//        System.out.print("Enter payment method: ");
//        String paymentMethod = scanner.nextLine();
//        scanner.nextLine(); // Consume newline
//
//        Payment payment = new Payment();
//        payment.setUserId(userId);
//        payment.setAmount(amount);
//        payment.setPaymentMethod(paymentMethod);
//
//        adminController.processPayment(payment);
//        System.out.println("Payment processed successfully.");
//    }
//
//    private void updatePayment() {
//        System.out.print("Enter payment ID to update: ");
//        int paymentId = scanner.nextInt();
//        System.out.print("Enter new amount: ");
//        double amount = scanner.nextDouble();
//        System.out.print("Enter new payment method: ");
//        String paymentMethod = scanner.nextLine();
//        scanner.nextLine(); // Consume newline
//
//        Payment payment = new Payment();
//        payment.setPaymentId(paymentId);
//        payment.setAmount(amount);
//        payment.setPaymentMethod(paymentMethod);
//
//        adminController.updatePayment(payment);
//        System.out.println("Payment updated successfully.");
//    }
//
//    private void deletePayment() {
//        System.out.print("Enter payment ID to delete: ");
//        int paymentId = scanner.nextInt();
//        scanner.nextLine(); // Consume newline
//
//        adminController.deletePayment(paymentId);
//        System.out.println("Payment deleted successfully.");
 //   }
}
