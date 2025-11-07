// Pattern Matching (Java 16+)

public class PatternMatching {
    
    // ❌ OLD WAY - Manual instanceof and cast
    public void oldWay(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;  // Manual cast
            System.out.println("String length: " + str.length());
        } else if (obj instanceof Integer) {
            Integer num = (Integer) obj;  // Manual cast
            System.out.println("Integer value: " + num);
        }
    }
    
    // ✅ NEW WAY - Pattern Matching (Java 16+)
    public void newWay(Object obj) {
        if (obj instanceof String str) {  // Automatic cast
            System.out.println("String length: " + str.length());
        } else if (obj instanceof Integer num) {  // Automatic cast
            System.out.println("Integer value: " + num);
        }
    }
    
    // ✅ Pattern Matching in Switch (Java 21+)
    public String patternMatchingSwitch(Object obj) {
        return switch (obj) {
            case String s -> "String: " + s + " (length: " + s.length() + ")";
            case Integer i -> "Integer: " + i;
            case Double d -> "Double: " + d;
            case null -> "Null value";
            default -> "Unknown type: " + obj.getClass().getSimpleName();
        };
    }
    
    // ✅ Pattern Matching with Guards
    public String patternMatchingWithGuards(Object obj) {
        return switch (obj) {
            case String s when s.length() > 10 -> "Long string: " + s;
            case String s -> "Short string: " + s;
            case Integer i when i > 100 -> "Large integer: " + i;
            case Integer i -> "Small integer: " + i;
            default -> "Other: " + obj;
        };
    }
    
    // ✅ Pattern Matching with Records
    public record Point(int x, int y) {}
    
    public String processPoint(Object obj) {
        return switch (obj) {
            case Point(int x, int y) when x == y -> "Point on diagonal: (" + x + ", " + y + ")";
            case Point(int x, int y) -> "Point: (" + x + ", " + y + ")";
            default -> "Not a point";
        };
    }
    
    // ✅ Nested Pattern Matching
    public record Address(String street, String city) {}
    public record Person(String name, Address address) {}
    
    public String processPerson(Object obj) {
        return switch (obj) {
            case Person(String name, Address(String street, String city)) 
                when city.equals("New York") -> 
                name + " lives in NYC at " + street;
            case Person(String name, Address addr) -> 
                name + " lives in " + addr.city();
            default -> "Not a person";
        };
    }
    
    // Usage Examples
    public static void main(String[] args) {
        PatternMatching pm = new PatternMatching();
        
        // Pattern matching with instanceof
        pm.newWay("Hello");
        pm.newWay(42);
        
        // Pattern matching switch
        System.out.println(pm.patternMatchingSwitch("Java"));
        System.out.println(pm.patternMatchingSwitch(21));
        System.out.println(pm.patternMatchingSwitch(null));
        
        // Pattern matching with records
        Point p = new Point(5, 5);
        System.out.println(pm.processPoint(p));
        
        // Nested pattern matching
        Person person = new Person("Alice", new Address("123 Main", "New York"));
        System.out.println(pm.processPerson(person));
    }
}

// ✅ Benefits of Pattern Matching:
// - Eliminates manual casts
// - More readable code
// - Type-safe
// - Reduces boilerplate
// - Works great with records and sealed classes

