// Primitive vs Wrapper Classes - When to Use What

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrimitiveWrapperDemo {
    
    // ✅ Use Primitives for:
    // - Performance-critical code
    // - Local variables
    // - Calculations
    public void usePrimitives() {
        int count = 0;           // ✅ Fast, no object overhead
        double price = 99.99;    // ✅ Direct value storage
        boolean isActive = true;  // ✅ Simple true/false
        
        // Calculations are faster
        for (int i = 0; i < 1000000; i++) {
            count += i;  // Primitive operations are fast
        }
    }
    
    // ✅ Use Wrapper Classes for:
    // - Collections (List, Set, Map)
    // - Nullable values
    // - Generic types
    public void useWrappers() {
        // Collections require objects
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);  // Autoboxing: int -> Integer
        numbers.add(20);
        
        // Nullable values
        Integer userId = getUserById(123);  // Can be null
        if (userId != null) {
            System.out.println("User ID: " + userId);
        }
        
        // Generic types
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 95);
        scores.put("Bob", 87);
    }
    
    // ⚠️ Watch out for autoboxing/unboxing overhead
    public void autoboxingOverhead() {
        Integer sum = 0;  // ❌ Creates new Integer object each time
        for (int i = 0; i < 1000; i++) {
            sum += i;  // Autoboxing/unboxing overhead
        }
        
        // ✅ Better: Use primitive
        int sumBetter = 0;
        for (int i = 0; i < 1000; i++) {
            sumBetter += i;  // No overhead
        }
    }
    
    // ✅ Best Practices
    public void bestPractices() {
        // Use primitives for local variables
        int age = 25;
        double salary = 50000.0;
        
        // Use wrappers when null is meaningful
        Integer optionalAge = getUserAge();  // null means "not provided"
        
        // Use primitives in method parameters when null doesn't make sense
        public void calculateTotal(int quantity, double price) {
            // quantity and price should never be null
        }
        
        // Use wrappers when null is valid
        public void setDiscount(Integer discountPercent) {
            // null means "no discount"
        }
    }
    
    private Integer getUserById(int id) {
        // Simulated method
        return id > 0 ? id : null;
    }
    
    private Integer getUserAge() {
        return null;  // Not provided
    }
}

