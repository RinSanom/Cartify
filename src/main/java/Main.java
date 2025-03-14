/*import model.repository.ProductRepository;
import model.repository.ProductRepositoryImpl;
import model.repository.OrderRepository;
import model.repository.OrderRepositoryImpl;
import model.repository.PaymentRepository;
import model.repository.PaymentRepositoryImpl;
import model.service.AdminService;
import controller.AdminController;
import view.AdminView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        ProductRepository productRepository = new ProductRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        // Initialize services
        AdminService adminService = new AdminService(productRepository, orderRepository, paymentRepository);

        // Initialize controller
        AdminController adminController = new AdminController(adminService);

        // Initialize view
        AdminView adminView = new AdminView(adminController);

        // Start the application
        AdminView view = new AdminView();
        AdminController controller = new AdminController();
        Scanner scanner = new Scanner(System.in);


    }
}
*/
import model.repository.ProductRepository;
import model.repository.ProductRepositoryImpl;
import model.repository.OrderRepository;
import model.repository.OrderRepositoryImpl;
import model.repository.PaymentRepository;
import model.repository.PaymentRepositoryImpl;
import model.service.AdminService;
import controller.AdminController;
import view.AdminView;

public class Main {
    public static void main(String[] args) {
        // Initialize repositories
        ProductRepository productRepository = new ProductRepositoryImpl();
        OrderRepository orderRepository = new OrderRepositoryImpl();
        PaymentRepository paymentRepository = new PaymentRepositoryImpl();

        // Initialize services
        AdminService adminService = new AdminService(productRepository, orderRepository, paymentRepository);

        // Initialize controller
        AdminController adminController = new AdminController(adminService);

        // Initialize view
        AdminView adminView = new AdminView(adminController);

        // Start the application
        adminView.displayMenu();
    }
}