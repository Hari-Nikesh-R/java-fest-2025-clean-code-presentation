// Method Design: Single Responsibility & Short Methods

// ❌ BAD - Method does too much
public class BadMethodDesign {
    public void processUserData(String name, String email, int age, String[] hobbies) {
        // Validation
        if (name == null || name.isEmpty()) {
            System.out.println("Error: Name required");
            return;
        }
        if (email == null || !email.contains("@")) {
            System.out.println("Error: Invalid email");
            return;
        }
        if (age < 0 || age > 150) {
            System.out.println("Error: Invalid age");
            return;
        }
        
        // Processing
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        String domain = email.substring(email.indexOf("@") + 1);
        
        // Database operations
        // db.save(formattedName, email, age);
        
        // Email sending
        // emailService.sendWelcomeEmail(email);
        
        // Logging
        System.out.println("User processed: " + formattedName);
        System.out.println("Domain: " + domain);
        System.out.println("Hobbies count: " + hobbies.length);
    }
}

// ✅ GOOD - Single Responsibility, Short Methods
public class GoodMethodDesign {
    public void processUserData(String name, String email, int age, String[] hobbies) {
        if (!isValidUserData(name, email, age)) {
            return;
        }
        
        String formattedName = formatName(name);
        String domain = extractDomain(email);
        
        saveUser(formattedName, email, age);
        sendWelcomeEmail(email);
        logUserProcessed(formattedName, domain, hobbies.length);
    }
    
    private boolean isValidUserData(String name, String email, int age) {
        return isValidName(name) && isValidEmail(email) && isValidAge(age);
    }
    
    private boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Name required");
            return false;
        }
        return true;
    }
    
    private boolean isValidEmail(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Error: Invalid email");
            return false;
        }
        return true;
    }
    
    private boolean isValidAge(int age) {
        if (age < 0 || age > 150) {
            System.out.println("Error: Invalid age");
            return false;
        }
        return true;
    }
    
    private String formatName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
    
    private String extractDomain(String email) {
        return email.substring(email.indexOf("@") + 1);
    }
    
    private void saveUser(String name, String email, int age) {
        // Database operations
        // db.save(name, email, age);
    }
    
    private void sendWelcomeEmail(String email) {
        // emailService.sendWelcomeEmail(email);
    }
    
    private void logUserProcessed(String name, String domain, int hobbiesCount) {
        System.out.println("User processed: " + name);
        System.out.println("Domain: " + domain);
        System.out.println("Hobbies count: " + hobbiesCount);
    }
}

// ✅ Benefits:
// - Each method has one responsibility
// - Easy to test individual methods
// - Easy to understand and maintain
// - Easy to reuse methods

