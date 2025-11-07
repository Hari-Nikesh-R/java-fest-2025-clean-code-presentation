// Writing Testable Code

// ❌ BAD - Hard to Test
public class HardToTest {
    private DatabaseConnection db = new DatabaseConnection();  // Hard dependency
    
    public void processOrder(String orderId) {
        Order order = db.getOrder(orderId);  // Can't test without database
        if (order != null) {
            order.setStatus("PROCESSED");
            db.saveOrder(order);  // Can't test without database
            EmailService.sendEmail(order.getCustomerEmail(), "Order processed");  // Can't test without email
        }
    }
}

// ✅ GOOD - Testable Code
public class TestableCode {
    private OrderRepository orderRepository;  // Interface, not concrete class
    private EmailService emailService;  // Interface, not concrete class
    
    // Dependency injection - can inject mocks for testing
    public TestableCode(OrderRepository orderRepository, EmailService emailService) {
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }
    
    public void processOrder(String orderId) {
        Order order = orderRepository.findById(orderId);
        if (order != null) {
            order.setStatus("PROCESSED");
            orderRepository.save(order);
            emailService.sendEmail(order.getCustomerEmail(), "Order processed");
        }
    }
}

// ✅ Interfaces for Dependency Injection
public interface OrderRepository {
    Order findById(String id);
    void save(Order order);
}

public interface EmailService {
    void sendEmail(String to, String subject);
}

// ✅ Benefits:
// - Can test without database
// - Can test without email service
// - Can use mocks/stubs
// - Easy to test edge cases
// - Fast unit tests

