// Naming Examples: Good vs Bad

// ❌ BAD NAMING
public class BadNaming {
    int x;  // What does x represent?
    String s;  // What is s?
    int temp;  // Temporary for what?
    
    void calc(int a, int b) {  // Calculate what?
        int r = a + b;
        return r;
    }
}

// ✅ GOOD NAMING
public class GoodNaming {
    private int studentAge;
    private String studentName;
    private int totalScore;
    
    public int calculateTotalScore(int mathScore, int scienceScore) {
        int total = mathScore + scienceScore;
        return total;
    }
}

// More Examples:
// ❌ Bad: d, dt, n, cnt, str
// ✅ Good: distance, dateTime, numberOfStudents, count, userName

// ❌ Bad: processData(), doStuff(), handle()
// ✅ Good: calculateAverage(), validateUserInput(), sendEmail()

