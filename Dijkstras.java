import java.util.Scanner;
public class DijkstraShortestPath {
    static int min(int m, int n) {
        return (m < n) ? m : n;
    }
    static void dijkstra(int[][] cost, int source, int n) {
        int[] tvertex = new int[n];
        int[] dist = new int[n];
        int min, u = 0, v, i, j;
        System.arraycopy(cost[source], 0, dist, 0, n);
        tvertex[source] = 1;
        dist[source] = 0;
        for (i = 0; i < n - 1; i++) {
            min = Integer.MAX_VALUE;
            for (j = 0; j < n; j++) {
                if (tvertex[j] == 0 && dist[j] < min) {
                    min = dist[j];
                    u = j;
                }
            }
            tvertex[u] = 1;
            for (v = 0; v < n; v++) {
                if (tvertex[v] == 0 && cost[u][v] != Integer.MAX_VALUE) {
                    dist[v] = min(dist[v], dist[u] + cost[u][v]);
                }
            }
        }
        System.out.println("The shortest travel time:");
        for (v = 0; v < n; v++) {
            System.out.println("From city " + source + " to city " + v + " is " + dist[v]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of cities: ");
        int n = scanner.nextInt();
        int[][] cost = new int[n][n];
        System.out.println("Enter the cost adjacency matrix (enter -1 if there is no direct path):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int input = scanner.nextInt();
                cost[i][j] = (input == -1) ? Integer.MAX_VALUE : input;
            }
        }
        System.out.print("Enter the source city: ");
        int source = scanner.nextInt();
        dijkstra(cost, source, n);
    }
}