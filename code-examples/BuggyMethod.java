// BUGGY METHOD - Refactoring Exercise
// Your task: Fix and refactor this method!

public class BuggyMethod {
    
    public void processData(String[] data, int maxSize, boolean validate) {
        int count = 0;
        String result = "";
        
        if (data != null) {
            for (int i = 0; i < data.length; i++) {
                if (data[i] != null) {
                    if (validate) {
                        if (data[i].length() > 0) {
                            if (count < maxSize) {
                                result = result + data[i] + ",";
                                count++;
                            } else {
                                System.out.println("Max size reached");
                                break;
                            }
                        } else {
                            System.out.println("Empty string found");
                        }
                    } else {
                        if (count < maxSize) {
                            result = result + data[i] + ",";
                            count++;
                        } else {
                            System.out.println("Max size reached");
                            break;
                        }
                    }
                }
            }
        }
        
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        
        System.out.println("Result: " + result);
        System.out.println("Count: " + count);
    }
    
    public static void main(String[] args) {
        BuggyMethod bm = new BuggyMethod();
        String[] testData = {"apple", "banana", "cherry", "", "date"};
        bm.processData(testData, 3, true);
    }
}

// ISSUES TO FIX:
// 1. Deep nesting (5 levels!)
// 2. Code duplication
// 3. Poor variable names
// 4. String concatenation in loop (inefficient)
// 5. Magic numbers/strings
// 6. No error handling
// 7. Method does too much
// 8. No validation of maxSize parameter
// 9. Inconsistent formatting
// 10. Hard to test

// REFACTORING HINTS:
// - Extract validation logic
// - Use early returns
// - Use StringBuilder for string concatenation
// - Extract methods for different concerns
// - Add proper error handling
// - Use meaningful names
// - Add input validation

