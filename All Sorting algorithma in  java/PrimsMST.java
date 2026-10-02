
import java.util.*;

public class PrimsMST {

    static void primMST(int[][] graph, int vertices) {
        int[] key = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] inMST = new boolean[vertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        key[0] = 0;

        for (int count = 0; count < vertices; count++) {
            int u = -1;

            // Find the unvisited vertex with minimum key
            for (int v = 0; v < vertices; v++) {
                if (!inMST[v] &&
                    (u == -1 || key[v] < key[u])) {
                    u = v;
                }
            }

            if (u == -1 || key[u] == Integer.MAX_VALUE) {
                System.out.println("Graph is disconnected.");
                return;
            }

            inMST[u] = true;

            // Update neighboring vertices
            for (int v = 0; v < vertices; v++) {
                if (graph[u][v] > 0 && !inMST[v]
                        && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                    parent[v] = u;
                }
            }
        }

        int totalWeight = 0;

        System.out.println("Edge   Weight");

        for (int v = 1; v < vertices; v++) {
            System.out.println(
                parent[v] + " - " + v + "     " + key[v]
            );
            totalWeight += key[v];
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };

        primMST(graph, graph.length);
    }
}
