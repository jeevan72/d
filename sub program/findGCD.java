
public class GCD {
    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        int num1 = 48;
        int num2 = 36;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
    }
}
