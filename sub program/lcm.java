
public class LCM {
    public static void main(String[] args) {
        int n1 = 72, n2 = 120;
        int lcm = findLCM(n1, n2);
        System.out.println("LCM of " + n1 + " and " + n2 + " is: " + lcm);
    }
    
    private static int findLCM(int a, int b) {
        return (a * b) / findGCD(a, b);
    }
    
    private static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        return findGCD(b, a % b);
    }
}