// MESSY CODE - Refactoring Exercise
// Your task: Clean this up!

public class MessyCode {
    int x;
    String y;
    int[] z;
    
    public void process(int a, String b, int[] c) {
        x = a;
        y = b;
        z = c;
        if (x > 0) {
            if (y != null) {
                if (y.length() > 0) {
                    if (z != null) {
                        if (z.length > 0) {
                            int sum = 0;
                            for (int i = 0; i < z.length; i++) {
                                sum = sum + z[i];
                            }
                            double avg = sum / z.length;
                            if (avg > 50) {
                                System.out.println("Good");
                            } else {
                                System.out.println("Bad");
                            }
                        }
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
        MessyCode mc = new MessyCode();
        int[] nums = {60, 70, 80};
        mc.process(10, "test", nums);
    }
}

// HINTS FOR REFACTORING:
// 1. Use meaningful names
// 2. Extract methods for validation
// 3. Reduce nesting (early returns)
// 4. Add proper encapsulation
// 5. Separate concerns

