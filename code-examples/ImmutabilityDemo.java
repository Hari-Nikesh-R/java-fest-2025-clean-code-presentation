// Immutability in Java

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutabilityDemo {
    
    // ✅ Using final for constants
    private static final int MAX_RETRY_ATTEMPTS = 3;
    private static final String API_BASE_URL = "https://api.example.com";
    
    // ✅ Using final for immutable references
    private final String userId;  // Cannot be reassigned after construction
    private final int accountNumber;
    
    public ImmutabilityDemo(String userId, int accountNumber) {
        this.userId = userId;
        this.accountNumber = accountNumber;
    }
    
    // ✅ String is immutable
    public void stringImmutability() {
        String name = "Java";
        name = name + " Programming";  // Creates new String object
        // Original "Java" string is unchanged
        
        // Better: Use StringBuilder for multiple concatenations
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");
        String result = sb.toString();
    }
    
    // ✅ Immutable collections (Java 9+)
    public void immutableCollections() {
        // List.of() creates immutable list
        var numbers = List.of(1, 2, 3, 4, 5);
        // numbers.add(6);  // ❌ UnsupportedOperationException
        
        // Set.of() creates immutable set
        var uniqueNames = Set.of("Alice", "Bob", "Charlie");
        
        // Map.of() creates immutable map
        var config = Map.of("host", "localhost", "port", "8080");
    }
    
    // ✅ Benefits of immutability
    // - Thread-safe
    // - No side effects
    // - Easier to reason about
    // - Prevents accidental modifications
}

