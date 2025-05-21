
public class SumOfSquare {
    public static void main(String[] args) {
        int n = 5; // Change this value to calculate sum of squares up to n
        int sum = 0;
        
        for(int i = 1; i <= n; i++) {
            sum += i * i;
        }
        
        System.out.println("Sum of squares from 1 to " + n + " is: " + sum);
    }
}
