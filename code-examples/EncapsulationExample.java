// Encapsulation - Data Hiding & Getters/Setters Done Right

// ❌ BAD - No Encapsulation
public class BadStudent {
    public String name;      // Direct access - anyone can modify
    public int age;          // No validation
    public double gpa;       // Can be set to invalid values
    
    // No control over data integrity
}

// ✅ GOOD - Proper Encapsulation
public class GoodStudent {
    // Private fields - data is hidden
    private String name;
    private int age;
    private double gpa;
    
    // Constructor with validation
    public GoodStudent(String name, int age, double gpa) {
        setName(name);
        setAge(age);
        setGpa(gpa);
    }
    
    // Getters - controlled access
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // Setters with validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    
    public void setAge(int age) {
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Age must be between 0 and 150");
        }
        this.age = age;
    }
    
    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("GPA must be between 0.0 and 4.0");
        }
        this.gpa = gpa;
    }
    
    // Business logic methods
    public boolean isHonorStudent() {
        return gpa >= 3.5;
    }
    
    public String getGradeLevel() {
        if (age < 6) return "Pre-school";
        if (age < 12) return "Elementary";
        if (age < 15) return "Middle School";
        if (age < 18) return "High School";
        return "College/Adult";
    }
}

// ✅ Benefits of Encapsulation:
// 1. Data integrity - validation in setters
// 2. Flexibility - can change internal implementation
// 3. Security - controlled access to data
// 4. Maintainability - single point of change

