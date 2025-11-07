// REFACTORING CHALLENGE SOLUTION - Modern Java 21 Style

import java.util.List;
import java.util.stream.Collectors;

// ✅ Modern Java 21 Solution
public class RefactoringChallengeSolution {
    
    // Modern, clean, readable version
    public List<String> processUsers(List<User> users) {
        if (users == null) {
            return List.of();
        }
        
        return users.stream()
            .filter(this::isValidUser)
            .map(this::formatUser)
            .collect(Collectors.toList());
    }
    
    private boolean isValidUser(User user) {
        return user != null
            && isValidName(user.getName())
            && isAdult(user.getAge())
            && isValidEmail(user.getEmail());
    }
    
    private boolean isValidName(String name) {
        return name != null && !name.isBlank();
    }
    
    private boolean isAdult(int age) {
        return age >= 18;
    }
    
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
    
    private String formatUser(User user) {
        return "%s (%d)".formatted(
            user.getName().toUpperCase(),
            user.getAge()
        );
    }
    
    // ✅ Even better: Use Record instead of class
    public record UserRecord(String name, int age, String email) {
        public UserRecord {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Name cannot be blank");
            }
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative");
            }
            if (email == null || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email");
            }
        }
    }
    
    // ✅ Process with Record
    public List<String> processUsersModern(List<UserRecord> users) {
        return users.stream()
            .filter(user -> user.age() >= 18)
            .map(user -> "%s (%d)".formatted(
                user.name().toUpperCase(),
                user.age()
            ))
            .toList();  // Java 16+ - simpler than Collectors.toList()
    }
}

// ✅ Comparison: Old vs New
// Old: 30+ lines, deep nesting, hard to read
// New: Clean, declarative, easy to test, maintainable

// ✅ Benefits of Modern Approach:
// 1. Readable - clear intent
// 2. Testable - each method can be tested independently
// 3. Maintainable - easy to modify
// 4. Modern - uses latest Java features
// 5. Functional - declarative style
// 6. Less code - fewer lines, more clarity

// Helper class (for compatibility)
class User {
    private final String name;
    private final int age;
    private final String email;
    
    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getEmail() { return email; }
}

