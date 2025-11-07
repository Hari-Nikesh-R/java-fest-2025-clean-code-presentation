// Cohesion & Coupling Examples

// ✅ HIGH COHESION - Class does one thing well
public class EmailValidator {
    // All methods are related to email validation
    public boolean isValidEmail(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }
    
    public boolean isValidDomain(String email) {
        String domain = email.substring(email.indexOf("@") + 1);
        return domain.length() > 0;
    }
    
    public String extractDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
}

// ❌ LOW COHESION - Class does multiple unrelated things
public class Utility {
    public boolean isValidEmail(String email) { /* ... */ }
    public void sendEmail(String to, String subject) { /* ... */ }
    public int calculateTax(double amount) { /* ... */ }
    public void printReport() { /* ... */ }
}

// ✅ LOOSE COUPLING - Dependencies on abstractions
public class OrderService {
    private PaymentProcessor paymentProcessor;  // Interface, not concrete class
    
    public OrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;  // Dependency injection
    }
    
    public void processOrder(Order order) {
        paymentProcessor.processPayment(order.getAmount());
    }
}

// ❌ TIGHT COUPLING - Direct dependency on concrete class
public class OrderServiceBad {
    private CreditCardProcessor processor = new CreditCardProcessor();  // Tight coupling!
    
    public void processOrder(Order order) {
        processor.charge(order.getAmount());  // Hard to test, hard to change
    }
}

