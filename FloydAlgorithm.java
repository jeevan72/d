import java.util.Scanner;
public class FloydAlgorithm {
    public static final int INF = 99999;
    public static int [][]Floyd(int[][] W, int n) {
        int[][] D = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = W[i][j];
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
        return D;
    }
    public static void printMatrix(int[][] matrix) {
        int n = matrix.length;
        System.out.println("Shortest path matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = sc.nextInt();
        int[][] W = new int[n][n];
        System.out.println("Enter the weight matrix (use " + INF + " for infinity):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                W[i][j] = sc.nextInt();
            }
        }
        int[][] result = Floyd(W, n);
        printMatrix(result);
    }
}
