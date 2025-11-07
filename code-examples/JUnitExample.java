// JUnit Testing Example
// Note: Requires JUnit 5 dependency
// Add to build.gradle: testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2'
// Or to pom.xml: <dependency><groupId>org.junit.jupiter</groupId><artifactId>junit-jupiter</artifactId><version>5.9.2</version></dependency>

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

// Example class to test
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
    
    public int subtract(int a, int b) {
        return a - b;
    }
    
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }
    
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}

// ✅ JUnit Test Class
public class CalculatorTest {
    private Calculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }
    
    @Test
    @DisplayName("Should add two positive numbers")
    void testAddPositiveNumbers() {
        // Arrange
        int a = 5;
        int b = 3;
        
        // Act
        int result = calculator.add(a, b);
        
        // Assert
        assertEquals(8, result);
    }
    
    @Test
    @DisplayName("Should add negative numbers")
    void testAddNegativeNumbers() {
        assertEquals(-5, calculator.add(-2, -3));
    }
    
    @Test
    @DisplayName("Should subtract two numbers")
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3));
        assertEquals(-2, calculator.subtract(3, 5));
    }
    
    @Test
    @DisplayName("Should divide two numbers")
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertEquals(0, calculator.divide(3, 6));
    }
    
    @Test
    @DisplayName("Should throw exception when dividing by zero")
    void testDivideByZero() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
        
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
    
    @Test
    @DisplayName("Should identify even numbers")
    void testIsEven() {
        assertTrue(calculator.isEven(2));
        assertTrue(calculator.isEven(0));
        assertTrue(calculator.isEven(-4));
        assertFalse(calculator.isEven(1));
        assertFalse(calculator.isEven(3));
    }
    
    @Test
    @DisplayName("Should handle multiple operations")
    void testMultipleOperations() {
        int result1 = calculator.add(5, 3);
        int result2 = calculator.subtract(result1, 2);
        assertEquals(6, result2);
    }
}

// ✅ Test Structure: AAA Pattern
// Arrange - Set up test data
// Act - Execute the method being tested
// Assert - Verify the results

// ✅ Common Assertions:
// assertEquals(expected, actual)
// assertTrue(condition)
// assertFalse(condition)
// assertNull(object)
// assertNotNull(object)
// assertThrows(Exception.class, () -> method())
// assertArrayEquals(expected, actual)

// ✅ Benefits of Testing:
// - Catch bugs early
// - Document expected behavior
// - Enable refactoring with confidence
// - Improve code design
// - Serve as examples

