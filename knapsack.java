import java.util.Scanner;
class Knapsack {
    static int n;
    static float m;
    static float[] p;
    static float[] w;
    static void greedy() {
        float max, u = m, profit = 0;
        int k = 0;
        System.out.println("Items included are:");
        for (int i = 0; i < n; i++) {
            max = 0;
            for (int j = 0; j < n; j++) {
                if (p[j] / w[j] > max && p[j] > 0) {
                    max = p[j] / w[j];
                    k = j;
                }
            }
            if (w[k] > u) {
                System.out.println((k + 1) + " item is selected");
                System.out.println("Fraction selected is " + (u / w[k]));
                profit = profit + (p[k] * u / w[k]);
                break;
            } else {
                System.out.println((k + 1) + " item is selected");
                System.out.println("Fraction selected is 1");
                u = u - w[k];
                profit = profit + p[k];
                p[k] = 0;
            }
        }
        System.out.println("Knapsack profit = " + profit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of items:");
        n = sc.nextInt();
        System.out.println("Enter the capacity of the knapsack:");
        m = sc.nextFloat();
        p = new float[n];
        w = new float[n];
        System.out.println("Enter the profit for each item:");
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextFloat();
        }
        System.out.println("Enter the weight for each item:");
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextFloat();
        }
        greedy();
        sc.close();
    }
}
