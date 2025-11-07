// Modern Java Features (Java 17-21)

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ModernJavaFeatures {
    
    // ✅ var keyword (Java 10+) - Local Variable Type Inference
    public void varKeyword() {
        // Old way
        String name = "Java";
        List<String> names = List.of("Alice", "Bob");
        Map<String, Integer> scores = new HashMap<>();
        
        // New way with var
        var name2 = "Java";  // Inferred as String
        var names2 = List.of("Alice", "Bob");  // Inferred as List<String>
        var scores2 = new HashMap<String, Integer>();  // Inferred as HashMap<String, Integer>
        
        // var is NOT a type - it's type inference
        // var x;  // ❌ Error: must initialize
        // var x = null;  // ❌ Error: can't infer from null
    }
    
    // ✅ Enhanced Switch Expressions (Java 14+)
    public String oldSwitch(int day) {
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default:
                dayName = "Unknown";
        }
        return dayName;
    }
    
    public String newSwitch(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Unknown";
        };
    }
    
    public String switchWithYield(int day) {
        return switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> {
                System.out.println("Invalid day");
                yield "Unknown";
            }
        };
    }
    
    // ✅ Records (Java 14+) - Lightweight Data Holders
    // Old way - lots of boilerplate
    public class OldPerson {
        private final String name;
        private final int age;
        
        public OldPerson(String name, int age) {
            this.name = name;
            this.age = age;
        }
        
        public String getName() { return name; }
        public int getAge() { return age; }
        
        @Override
        public boolean equals(Object o) { /* ... */ }
        @Override
        public int hashCode() { /* ... */ }
        @Override
        public String toString() { /* ... */ }
    }
    
    // New way - Records
    public record Person(String name, int age) {
        // Automatically gets:
        // - Constructor
        // - Getters (name(), age())
        // - equals(), hashCode(), toString()
        // - Immutable by default
    }
    
    public void useRecord() {
        Person person = new Person("Alice", 30);
        System.out.println(person.name());  // Getter
        System.out.println(person.age());
        System.out.println(person);  // toString() automatically implemented
    }
    
    // ✅ Pattern Matching for instanceof (Java 16+)
    public void oldInstanceof(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;  // Manual cast
            System.out.println(str.length());
        }
    }
    
    public void newPatternMatching(Object obj) {
        if (obj instanceof String str) {  // Automatic cast
            System.out.println(str.length());  // str is already String
        }
    }
    
    public void patternMatchingSwitch(Object obj) {
        String result = switch (obj) {
            case String s -> "String: " + s;
            case Integer i -> "Integer: " + i;
            case null -> "Null";
            default -> "Unknown";
        };
    }
    
    // ✅ Text Blocks (Java 15+) - Multi-line strings
    public void textBlocks() {
        // Old way
        String oldJson = "{\n" +
            "  \"name\": \"Java\",\n" +
            "  \"version\": 21\n" +
            "}";
        
        // New way
        String newJson = """
            {
              "name": "Java",
              "version": 21
            }
            """;
    }
    
    // ✅ Stream API - Functional Programming
    public void streamExamples() {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David");
        
        // Filter and map
        List<String> upperNames = names.stream()
            .filter(name -> name.length() > 4)
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        
        // Find first
        String firstLongName = names.stream()
            .filter(name -> name.length() > 5)
            .findFirst()
            .orElse("Not found");
        
        // Count
        long count = names.stream()
            .filter(name -> name.startsWith("C"))
            .count();
    }
}

