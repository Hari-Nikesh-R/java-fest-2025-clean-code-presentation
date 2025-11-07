// Error Handling Best Practices

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ErrorHandling {
    
    // ✅ GOOD - Specific Exception Handling
    public void readFile(String filename) {
        try {
            FileReader reader = new FileReader(filename);
            // Read file...
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            // Handle file not found
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            // Handle IO error
        }
    }
    
    // ✅ BETTER - Try-with-resources (Java 7+)
    public void readFileBetter(String filename) {
        try (FileReader reader = new FileReader(filename)) {
            // Read file...
            // Automatically closes resource
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    // ✅ GOOD - Custom Exceptions
    public class InvalidUserException extends Exception {
        public InvalidUserException(String message) {
            super(message);
        }
    }
    
    public void validateUser(String email, int age) throws InvalidUserException {
        if (email == null || !email.contains("@")) {
            throw new InvalidUserException("Invalid email: " + email);
        }
        if (age < 0 || age > 150) {
            throw new InvalidUserException("Invalid age: " + age);
        }
    }
    
    // ✅ GOOD - Using Custom Exception
    public void registerUser(String email, int age) {
        try {
            validateUser(email, age);
            // Register user...
        } catch (InvalidUserException e) {
            System.err.println("Registration failed: " + e.getMessage());
            // Handle validation error
        }
    }
    
    // ❌ BAD - Catching Generic Exception
    public void badErrorHandling() {
        try {
            // Some code...
        } catch (Exception e) {  // Too broad!
            // Catches everything - hard to debug
        }
    }
    
    // ❌ BAD - Swallowing Exceptions
    public void badErrorHandling2() {
        try {
            // Some code...
        } catch (Exception e) {
            // Empty catch block - exception is ignored!
        }
    }
    
    // ✅ GOOD - Finally Block for Cleanup
    public void processWithCleanup() {
        FileReader reader = null;
        try {
            reader = new FileReader("data.txt");
            // Process file...
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error closing file: " + e.getMessage());
                }
            }
        }
    }
    
    // ✅ BEST - Try-with-resources (automatic cleanup)
    public void processWithCleanupBetter() {
        try (FileReader reader = new FileReader("data.txt")) {
            // Process file...
            // Automatically closes in finally
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    // ✅ GOOD - Exception Chaining
    public void processData() throws DataProcessingException {
        try {
            // Some processing...
        } catch (IOException e) {
            throw new DataProcessingException("Failed to process data", e);
        }
    }
    
    public class DataProcessingException extends Exception {
        public DataProcessingException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

