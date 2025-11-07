// REFACTORING CHALLENGE - Old-School Java Code
// Your task: Refactor this into modern Java 21 style!

import java.util.ArrayList;
import java.util.List;

public class RefactoringChallenge {
    
    // Old Java style - refactor this!
    public List<String> processUsers(List<User> users) {
        List<String> result = new ArrayList<String>();
        
        if (users != null) {
            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                if (user != null) {
                    String name = user.getName();
                    if (name != null) {
                        if (name.length() > 0) {
                            int age = user.getAge();
                            if (age >= 18) {
                                String email = user.getEmail();
                                if (email != null) {
                                    if (email.contains("@")) {
                                        String upperName = name.toUpperCase();
                                        String formatted = upperName + " (" + age + ")";
                                        result.add(formatted);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }
    
    // Helper class
    public static class User {
        private String name;
        private int age;
        private String email;
        
        public User(String name, int age, String email) {
            this.name = name;
            this.age = age;
            this.email = email;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getEmail() { return email; }
    }
    
    // Test it
    public static void main(String[] args) {
        RefactoringChallenge challenge = new RefactoringChallenge();
        
        List<User> users = new ArrayList<User>();
        users.add(new User("Alice", 25, "alice@example.com"));
        users.add(new User("Bob", 17, "bob@example.com"));
        users.add(new User("Charlie", 30, "invalid-email"));
        users.add(new User(null, 22, "test@example.com"));
        
        List<String> result = challenge.processUsers(users);
        for (String s : result) {
            System.out.println(s);
        }
    }
}

// REFACTORING HINTS:
// 1. Use Stream API instead of loops
// 2. Use modern Java features (var, records, pattern matching)
// 3. Reduce nesting with early returns/filters
// 4. Extract validation logic
// 5. Use method references where possible
// 6. Make it more readable and maintainable

