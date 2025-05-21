import java.util.Scanner;
public class NewClass2 
{
    static int n, m, p[], w[];
    static void knap()
    {
        int[][] v = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
            {
                if (i == 0 || j == 0)
                    v[i][j] = 0;
                else if (j < w[i])
                    v[i][j] = v[i - 1][j];
                else 
                    v[i][j] = max(v[i - 1][j], p[i] + v[i - 1][j - w[i]]);
            }
        }
        for (int i = 0; i <= n; i++)
        {
            for (int j = 0; j <= m; j++)
                System.out.print(v[i][j] + " ");
            System.out.println();
        }
        System.out.println("Optimal profit is: " + v[n][m]);
        System.out.println("Products selected are:");
        while (n != 0)
        {
            if (v[n][m]!= v[n-1][m])
            {
                System.out.println(n + " ");
                m = m - w[n];
            }
            n--;
        }
    }
    static int max(int a, int b)
    {
        return (a > b ? a : b);
    }
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of products");
        n = s.nextInt();
        p = new int[n + 1];
        w = new int[n + 1];
        System.out.println("Enter the weights of n products");
        for (int i = 1; i <= n; i++)
            w[i] = s.nextInt();
        System.out.println("Enter the profits of n products");
        for (int i = 1; i <= n; i++)
            p[i] = s.nextInt();
        System.out.println("Enter the capacity of shelf (Knapsack)");
        m = s.nextInt();
        knap();
    }
}
