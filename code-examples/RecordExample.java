// Records - Lightweight Data Holders (Java 14+)

// ✅ Simple Record
public record Point(int x, int y) {
    // Automatically gets:
    // - Public final fields
    // - Public constructor
    // - Public accessors (x(), y())
    // - equals(), hashCode(), toString()
}

// ✅ Record with Custom Methods
public record Person(String name, int age) {
    // Custom constructor with validation
    public Person {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }
    
    // Custom instance method
    public boolean isAdult() {
        return age >= 18;
    }
    
    // Custom static method
    public static Person createMinor(String name, int age) {
        if (age >= 18) {
            throw new IllegalArgumentException("Must be under 18");
        }
        return new Person(name, age);
    }
}

// ✅ Record with Nested Records
public record Address(String street, String city, String zipCode) {}

public record Employee(String name, int id, Address address) {}

// Usage
public class RecordExample {
    public static void main(String[] args) {
        // Simple record
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        
        System.out.println(p1);  // Point[x=10, y=20]
        System.out.println(p1.equals(p2));  // true
        System.out.println(p1.x());  // 10
        System.out.println(p1.y());  // 20
        
        // Person record
        Person person = new Person("Alice", 30);
        System.out.println(person.isAdult());  // true
        
        // Employee with nested Address
        Address address = new Address("123 Main St", "New York", "10001");
        Employee employee = new Employee("Bob", 123, address);
        System.out.println(employee.address().city());  // New York
    }
}

// ✅ Records vs Classes
// Use Records when:
// - Data carrier (DTOs, value objects)
// - Immutable data
// - Simple data structures
// - When you need equals/hashCode/toString

// Use Classes when:
// - Need mutable state
// - Complex behavior
// - Inheritance needed
// - Need to extend other classes

