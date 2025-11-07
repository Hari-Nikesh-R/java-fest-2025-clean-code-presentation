// Logging vs System.out.println()

import java.util.logging.Logger;
import java.util.logging.Level;

public class LoggingExample {
    
    // ❌ BAD - Using System.out.println()
    public class BadLogging {
        public void processOrder(String orderId) {
            System.out.println("Processing order: " + orderId);
            // Process order...
            System.out.println("Order processed successfully");
        }
        
        public void handleError(String error) {
            System.out.println("Error: " + error);  // No log levels!
        }
    }
    
    // ✅ GOOD - Using Logger
    public class GoodLogging {
        private static final Logger logger = Logger.getLogger(GoodLogging.class.getName());
        
        public void processOrder(String orderId) {
            logger.info("Processing order: " + orderId);
            try {
                // Process order...
                logger.info("Order processed successfully: " + orderId);
            } catch (Exception e) {
                logger.severe("Failed to process order: " + orderId + " - " + e.getMessage());
                throw e;
            }
        }
        
        public void handleError(String error) {
            logger.severe("Error occurred: " + error);
        }
        
        public void debugInfo(String info) {
            logger.fine("Debug info: " + info);  // Only shown in debug mode
        }
    }
    
    // ✅ Log Levels (from most to least severe)
    public void demonstrateLogLevels() {
        Logger logger = Logger.getLogger(LoggingExample.class.getName());
        
        logger.severe("SEVERE: Critical error that stops execution");
        logger.warning("WARNING: Something unexpected but recoverable");
        logger.info("INFO: General informational message");
        logger.config("CONFIG: Configuration information");
        logger.fine("FINE: Detailed tracing information");
        logger.finer("FINER: Very detailed tracing");
        logger.finest("FINEST: Most detailed tracing");
    }
    
    // ✅ Best Practices
    public class LoggingBestPractices {
        private static final Logger logger = Logger.getLogger(LoggingBestPractices.class.getName());
        
        // ✅ Use appropriate log levels
        public void example1() {
            logger.info("User logged in: " + getUserId());
            logger.warning("Failed login attempt for user: " + getUserId());
            logger.severe("Database connection failed");
        }
        
        // ✅ Include context in log messages
        public void example2(String orderId, double amount) {
            logger.info(String.format("Order %s processed with amount $%.2f", orderId, amount));
        }
        
        // ✅ Log exceptions with stack traces
        public void example3() {
            try {
                // Some operation...
            } catch (Exception e) {
                logger.log(Level.SEVERE, "Operation failed", e);  // Includes stack trace
            }
        }
        
        // ✅ Use parameterized logging (if available)
        public void example4(String userId, int count) {
            logger.log(Level.INFO, "User {0} has {1} items", new Object[]{userId, count});
        }
        
        private String getUserId() {
            return "user123";
        }
    }
    
    // ✅ Benefits of Logging:
    // - Configurable log levels (can turn off debug in production)
    // - Can redirect to files, databases, etc.
    // - Better for production debugging
    // - Professional standard
    // - Can filter by severity
}

