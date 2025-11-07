// BAD EXAMPLE - Poorly written code
public class x {
    int a;
    String b;
    public void m(int c, String d) {
        a = c;
        b = d;
        if (a > 0) {
            if (b != null) {
                if (b.length() > 5) {
                    System.out.println("ok");
                }
            }
        }
    }
    public static void main(String[] args) {
        x obj = new x();
        obj.m(10, "hello world");
    }
}

