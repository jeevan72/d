package topsorts;

import java.util.Scanner;

public class newclsass {
    static int[] w;
    static int[] x;
    static String[] categories;
    static int d, count = 0;
    static void sum(int s,int k,int rem) {
        x[k] = 1;
        if (s+w[k]==d) {
            System.out.println("Subset = " + (++count));
            for (int i=0;i<=k;i++) {
                if (x[i]==1) {
                    System.out.println(categories[i]+": "+w[i]);
                }
            }
            System.out.println();
        } else if (k+1<w.length&&s+w[k]+w[k+1]<=d) {
            sum(s + w[k], k + 1, rem - w[k]);
        }
        if (k+1<w.length && s+rem-w[k]>=d&&s+w[k+1]<=d) {
            x[k] = 0;
            sum(s,k+1,rem-w[k]);
        }
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of categories: ");
        int n = s.nextInt();
        w = new int[n];
        x = new int[n];
        categories = new String[n];
        int totalSum = 0;
        s.nextLine(); 
        for (int i=0;i<n;i++) {
            System.out.print("Enter name for category " + (i+1)+":");
            categories[i] = s.nextLine();
            System.out.print("categories "+ (i+1) + " name");
            w[i] = s.nextInt();
            totalSum += w[i];
            s.nextLine(); 
        }
        System.out.print("Enter the budget: ");
        d = s.nextInt();

        if (totalSum < d || w[0] > d) {
            System.out.println("No subset possible.");
        } else {
            sum(0, 0, totalSum);
        }
    }
}
